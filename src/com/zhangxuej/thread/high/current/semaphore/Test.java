package com.zhangxuej.thread.high.current.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Java线程：新特征-信号量
 * 
 * @author hadoop
 */
public class Test {

	public static void main(String[] args) {
		MyPool myPool = new MyPool(20);
		// 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		MyThread t1 = new MyThread("任务A", myPool, 21);
		MyThread t2 = new MyThread("任务B", myPool, 12);
		MyThread t3 = new MyThread("任务C", myPool, 7);
		
		// 在线程池中执行任务
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		
		// 关闭线程池
		pool.shutdown();
	}

}

/**
 * 一个池
 */
class MyPool {

	private Semaphore sp; // 池相关的信号量

	/**
	 * 池的大小，这个大小会传递给信号量
	 * 
	 * @param size
	 */
	public MyPool(int size) {
		this.sp = new Semaphore(size);
	}

	public Semaphore getSp() {
		return sp;
	}

	public void setSp(Semaphore sp) {
		this.sp = sp;
	}

}

class MyThread extends Thread {

	private String threadname; // 线程的名字
	private MyPool myPool; // 自定义线程池
	private int x; // 申请信号量的大小

	public MyThread(String threadname, MyPool myPool, int x) {
		this.threadname = threadname;
		this.myPool = myPool;
		this.x = x;
	}

	@Override
	public void run() {
		try {
			// 从此信号量获取给定数目的许可
			myPool.getSp().acquire(x);
			// TODO 也许这里可以做更复杂的业务
			System.out.println(threadname + "成功获取了" + x + "个许可！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 释放给定数目的许可，将其返回到信号量
			myPool.getSp().release(x);
			System.out.println(threadname + "释放了" + x + "个许可！");
		}
	}

}