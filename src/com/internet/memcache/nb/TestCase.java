package com.internet.memcache.nb;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.auth.AuthInfo;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.transcoders.StringTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.junit.Test;

public class TestCase { 
//	@Test
	//
//	public void test1() throws IOException {
//		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
//				AddrUtil.getAddresses("192.168.139.128:11211"));
//		// AddrUtil.getAddresses("server1:11211 server2:11211")
//               // 崻�����  
//               builder.setFailureMode(true);  
//              // ʹ�ö������ļ�  
//               builder.setCommandFactory(new BinaryCommandFactory());
//            /** 
//             * �������ӳش�С�����ͻ��˸��� 
//             * In a high concurrent enviroment,you may want to pool memcached clients. 
//             * But a xmemcached client has to start a reactor thread and some thread pools, 
//             * if you create too many clients,the cost is very large.  
//             * Xmemcached supports connection pool instreadof client pool. 
//             * you can create more connections to one or more memcached servers, 
//             * and these connections share the same reactor and thread pools, 
//             * it will reduce the cost of system. 
//             *  Ĭ�ϵ�pool size��1��������һ��ֵ��һ����������ܣ������������Ŀ�Ĳ��Խ��Ϊ׼�������Ĳ��Ա���ֻ���ڴ󲢷��²��������� 
//             *  �������ӳص�һ������������ǣ�ͬһ��memcached������֮������ݸ��²���ͬ���� 
//             *  ������Ӧ����Ҫ�Լ���֤���ݸ��µ�ԭ���ԣ�����CAS��������֮����޹������� 
//             */  
//                builder.setConnectionPoolSize(10);  
//		MemcachedClient client = builder.build();
//		try {
//			/**
//			 * ��һ���Ǵ洢��key���ƣ�
//			 * �ڶ�����expireʱ�䣨��λ�룩���������ʱ��,memcached����������滻��ȥ��0��ʾ���ô洢��Ĭ����һ����)
//			 * ��������������ʵ�ʴ洢������
//			 */
//			client.set("hello", 0, "Hello,xmemcached");
//			String value = client.get("hello");
//			System.out.println("hello=" + value);
//			client.delete("hello");
//			value = client.get("hello");
//			System.out.println("hello=" + value);

	public void test1() throws IOException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("192.168.142.128:11211"));
		// 崻�����
		builder.setFailureMode(true);
		// ʹ�ö������ļ�
		builder.setCommandFactory(new BinaryCommandFactory());
		/** 
         * �������ӳش�С�����ͻ��˸��� 
         * In a high concurrent enviroment,you may want to pool memcached clients. 
         * But a xmemcached client has to start a reactor thread and some thread pools, 
         * if you create too many clients,the cost is very large.  
         * Xmemcached supports connection pool instreadof client pool. 
         * you can create more connections to one or more memcached servers, 
         * and these connections share the same reactor and thread pools, 
         * it will reduce the cost of system. 
         *  Ĭ�ϵ�pool size��1��������һ��ֵ��һ����������ܣ������������Ŀ�Ĳ��Խ��Ϊ׼�������Ĳ��Ա���ֻ���ڴ󲢷��²��������� 
         *  �������ӳص�һ������������ǣ�ͬһ��memcached������֮������ݸ��²���ͬ���� 
         *  ������Ӧ����Ҫ�Լ���֤���ݸ��µ�ԭ���ԣ�����CAS��������֮����޹������� 
         */
		builder.setConnectionPoolSize(10);
		MemcachedClient client = builder.build();
		
		/**
		 * ��һ���Ǵ洢��key���ƣ�
		 * �ڶ�����expireʱ�䣨��λ�룩���������ʱ��,memcached����������滻��ȥ��0��ʾ���ô洢��Ĭ����һ����)
		 * ��������������ʵ�ʴ洢������
		 */
		try {
			client.set("hello", 0, "Hello,xmemcached");
			String value = client.get("hello");
			System.out.println("hello=" + value);
			client.delete("hello");
			value = client.get("hello");
			System.out.println("hello=" + value);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			// value=client.get(��hello��,3000);

			/**
			 * Memcached��ͨ��casЭ��ʵ��ԭ�Ӹ��£���νԭ�Ӹ��¾���compare and set��
			 * ԭ�������ֹ�����ÿ������洢ĳ������ͬʱҪ����һ��casֵ�� memcached�ȶ����casֵ�뵱ǰ�洢���ݵ�casֵ�Ƿ���ȣ�
			 * �����Ⱦ����µ����ݸ����ϵ����ݣ��������Ⱦ���Ϊ����ʧ�ܣ� ���ڲ����������ر�����
			 */
			try {
				GetsResponse<Integer> result = client.gets("a");
				long cas = result.getCas();
				// ���Խ�a��ֵ����Ϊ2
				if (!client.cas("a", 0, 2, cas)) {
					System.err.println("cas error");
				}
			} catch (TimeoutException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MemcachedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			// close memcached client
			client.shutdown();
		} catch (IOException e) {
			System.err.println("Shutdown MemcachedClient fail");
			e.printStackTrace();
		}

		// value=client.get(��hello��,3000);

		/**
		 * Memcached��ͨ��casЭ��ʵ��ԭ�Ӹ��£���νԭ�Ӹ��¾���compare and set��
		 * ԭ�������ֹ�����ÿ������洢ĳ������ͬʱҪ����һ��casֵ�� memcached�ȶ����casֵ�뵱ǰ�洢���ݵ�casֵ�Ƿ���ȣ�
		 * �����Ⱦ����µ����ݸ����ϵ����ݣ��������Ⱦ���Ϊ����ʧ�ܣ� ���ڲ����������ر�����
		 */
	}

	@Test
	public void test2() throws TimeoutException, InterruptedException,
			MemcachedException, IOException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("192.168.139.128:11211"));
		MemcachedClient client = builder.build();
		client.flushAll();
		if (!client.set("hello", 0, "world")) {
			System.err.println("set error");
		}
		if (client.add("hello", 0, "dennis")) {
			System.err.println("Add error,key is existed");
		}
		if (!client.replace("hello", 0, "dennis")) {
			System.err.println("replace error");
		}
		client.append("hello", " good");
		client.prepend("hello", "hello ");
		String name = client.get("hello", new StringTranscoder());
		System.out.println(name);

		/**
		 * ��ɾ����������ͨ��deleteWithNoReply�������������ɾ�����ݲ��Ҹ���memcached
		 * ���÷���Ӧ����������������ȴ�Ӧ��ֱ�ӷ��أ��ر��ʺ�����������
		 */
		client.deleteWithNoReply("hello");
	}

	@Test
	public void incrDecr() throws IOException, TimeoutException,
			InterruptedException, MemcachedException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("192.168.139.128:11211"));
		MemcachedClient client = builder.build();
		/**
		 * ��һ������ָ��������key���ƣ� �ڶ�������ָ�������ķ��ȴ�С�� ����������ָ����key�����ڵ�����µĳ�ʼֵ��
		 * �������������ط���ʡ���˵�����������Ĭ��ָ��Ϊ0��
		 */
		assert (1 == client.incr("a", 5, 1));
		assert (6 == client.incr("a", 5));
		assert (10 == client.incr("a", 4));
		assert (9 == client.decr("a", 1));
		assert (7 == client.decr("a", 2));
	}

	@Test
	public void counter() throws Exception {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("192.168.139.128:11211"));
		MemcachedClient client = builder.build();
		Counter counter = client.getCounter("counter", 0);
		counter.incrementAndGet();
		counter.decrementAndGet();
		counter.addAndGet(-10);
	}

	public void auth() throws Exception {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("192.168.139.128:11211"));
		builder.addAuthInfo(AddrUtil.getOneAddress("192.168.139.128:11211"),
				AuthInfo.typical("cacheuser", "123456"));
		// Must use binary protocol
		builder.setCommandFactory(new BinaryCommandFactory());
		MemcachedClient client = builder.build();
	}

	public void nioPool() throws Exception {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("192.168.139.128:11211"));
		builder.setConnectionPoolSize(5);
	}

	
	/**
     *����Ӧ�ð�װkestrel��Ϣ������������ʹ������API��Ч
	 * @throws IOException
	 * @throws MemcachedException 
	 * @throws InterruptedException 
	 * @throws TimeoutException 
	 */
	@Test
	public void testGet() throws IOException, TimeoutException, InterruptedException, MemcachedException{
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("192.168.139.128:11212"));
		MemcachedClient client = builder.build();
		String value = client.get("1");
		System.out.println("hello=" + value);
	}
	
	
	@Test
    public void testGet2() throws IOException, TimeoutException, InterruptedException, MemcachedException{
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                AddrUtil.getAddresses("192.168.139.128:11212"));
        MemcachedClient client = builder.build();
	}
        
}
