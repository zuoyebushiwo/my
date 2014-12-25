package com.zuoye.thread.high.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService pool = null; 
		// 创建一个可重用固定线程数的线程池 
		pool = Executors.newFixedThreadPool(2);
		// 创建一个使用单个worker线程的Executor，以无解队列方式来运行该线程
		pool = Executors.newSingleThreadExecutor();
		// 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用他们
		pool = Executors.newCachedThreadPool();
		// 创建一个线程池，它可以在给定延迟后运行命令或者定期执行。
		pool = Executors.newScheduledThreadPool(2);
		for (int i = 0; i < 5; i++) {
			Thread thread = new MyThread();
			if (i < 3) {
				pool.execute(thread);
			} else {
				((ScheduledExecutorService) pool).schedule(thread, 2000, TimeUnit.MILLISECONDS);
			}
		}
		
		// 关闭线程池
		pool.shutdown();
	}

}

class MyThread extends Thread {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在执行...");
	}
	
}