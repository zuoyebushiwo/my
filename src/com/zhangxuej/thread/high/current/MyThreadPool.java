package com.zhangxuej.thread.high.current;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

	public static void main(String[] args) {
		// 创建等待队列
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);

		// 创建一个单线程执行程序，它可以安排在给定延迟后运行命令或者定期执行
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2,
				TimeUnit.MICROSECONDS, bqueue);
		
		for (int i = 0; i < 7; i++) {
			Thread t = new MyThread1();
			pool.execute(t);
		}
		pool.shutdown();
	}

}

class MyThread1 extends Thread {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在执行...");
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}