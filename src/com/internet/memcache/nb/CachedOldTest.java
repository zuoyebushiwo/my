package com.internet.memcache.nb;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;


/**
 * 测试MemCached缓存
 */
public class CachedOldTest {

	static class TestWriteRunnable implements Runnable {

		private MemCachedClient mc;
		private CountDownLatch cd;

		int repeat;
		int start;

		public TestWriteRunnable(MemCachedClient mc, int start,
				CountDownLatch cdl, int repeat) {
			super();
			this.mc = mc;
			this.start = start;
			this.cd = cdl;
			this.repeat = repeat;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < repeat; i++) {
					String key = String.valueOf(start + i);
					if (!mc.set(key, key, new Date(500 * 1000))) {
						System.err.println("Set error");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cd.countDown();
			}
		}
	}

	static class TestReadRunnable implements Runnable {

		private MemCachedClient mc;
		private CountDownLatch cd;
		int repeat;
		int start;

		public TestReadRunnable(MemCachedClient mc, int start,
				CountDownLatch cdl, int repeat) {
			super();
			this.mc = mc;
			this.start = start;
			this.cd = cdl;
			this.repeat = repeat;

		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < repeat; i++) {
					String key = String.valueOf(start + i);
					String result = (String) mc.get(key);
					if (!key.equals(result)) {
						System.out.println(key + " " + result);
						System.err.println("get error");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cd.countDown();
			}
		}
	}

	static class TestDeleteRunnable implements Runnable {

		private MemCachedClient mc;
		private CountDownLatch cd;
		int repeat;
		int start;

		public TestDeleteRunnable(MemCachedClient mc, int start,
				CountDownLatch cdl, int repeat) {
			super();
			this.mc = mc;
			this.start = start;
			this.cd = cdl;
			this.repeat = repeat;

		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < repeat; i++) {
					String key = String.valueOf(start + i);
					if (!mc.delete(key))
						System.err.println("delete error");
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cd.countDown();
			}
		}

	}

	/**
	 * 测试主方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int size = Runtime.getRuntime().availableProcessors();
		int thread = 10;
		int repeat = 10000;

		MemCachedClient mc = null;
		SockIOPool testpool;
		testpool = SockIOPool.getInstance("testpool"); // 存储用户对象
		String[] tmparr = new String[] { "192.168.139.128:11211" };
		testpool.setServers(tmparr); // 一个客户端可以指定多个服务器
		testpool.setWeights(new Integer[] { 3 });// 设置权重
		testpool.setInitConn(10);
		testpool.setMinConn(5);
		testpool.setMaxConn(50);
		testpool.setMaxIdle(1800000);
		testpool.setMaxBusyTime(300000);
		testpool.setMaintSleep(5000);
		testpool.setHashingAlg(SockIOPool.NEW_COMPAT_HASH);
		testpool.setSocketTO(3000);
		testpool.setSocketConnectTO(3000);
		testpool.setNagle(false);
		testpool.setFailover(false);
		testpool.setAliveCheck(true);
		testpool.initialize();
		mc = new MemCachedClient("testpool");

		CountDownLatch cdl = new CountDownLatch(thread);
		// 测试写
		long t = System.currentTimeMillis();
		for (int i = 0; i < thread; i++) {
			new Thread(new CachedOldTest.TestWriteRunnable(mc, i * 10000, cdl,
					repeat)).start();
		}

		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long all = thread * repeat;
		long usingtime = (System.currentTimeMillis() - t);

		System.out
				.println(String
						.format("===test write,thread num=%d, repeat=%d,size=%d, all=%d ,velocity=%d , using time:%d",
								thread, repeat, size, all, 1000 * all
										/ usingtime, usingtime));

		// 测试读
		cdl = new CountDownLatch(thread);
		t = System.currentTimeMillis();
		for (int i = 0; i < thread; i++) {
			new Thread(new CachedOldTest.TestReadRunnable(mc, i * 10000, cdl,
					repeat)).start();
		}
		try {
			cdl.await();
			System.out.println("11");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		all = thread * repeat;
		usingtime = (System.currentTimeMillis() - t);
		System.out
				.println(String
						.format("====test read,thread num=%d, repeat=%d,size=%d, all=%d ,velocity=%d , using time:%d",
								thread, repeat, size, all, 1000 * all
										/ usingtime, usingtime));
		// 测试删除
		cdl = new CountDownLatch(thread);
		t = System.currentTimeMillis();
		for (int i = 0; i < thread; i++) {
			new Thread(new CachedOldTest.TestDeleteRunnable(mc, i * 10000, cdl,
					repeat)).start();
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {

		}
		all = thread * repeat;
		usingtime = (System.currentTimeMillis() - t);
		System.out
				.println(String
						.format("====test delete,thread num=%d, repeat=%d,size=%d, all=%d ,velocity=%d , using time:%d",
								thread, repeat, size, all, 1000 * all
										/ usingtime, usingtime));

		testpool.shutDown();
	}

}
