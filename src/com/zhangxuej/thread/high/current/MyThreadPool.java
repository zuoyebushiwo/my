package com.zhangxuej.thread.high.current;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

	public static void main(String[] args) {
		// �����ȴ�����
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);

		// ����һ�����߳�ִ�г��������԰����ڸ����ӳٺ�����������߶���ִ��
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
		System.out.println(Thread.currentThread().getName() + "����ִ��...");
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}