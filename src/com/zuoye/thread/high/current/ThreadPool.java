package com.zuoye.thread.high.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService pool = null; 
		// ����һ�������ù̶��߳������̳߳� 
		pool = Executors.newFixedThreadPool(2);
		// ����һ��ʹ�õ���worker�̵߳�Executor�����޽���з�ʽ�����и��߳�
		pool = Executors.newSingleThreadExecutor();
		// ����һ���ɸ�����Ҫ�������̵߳��̳߳أ���������ǰ������߳̿���ʱ����������
		pool = Executors.newCachedThreadPool();
		// ����һ���̳߳أ��������ڸ����ӳٺ�����������߶���ִ�С�
		pool = Executors.newScheduledThreadPool(2);
		for (int i = 0; i < 5; i++) {
			Thread thread = new MyThread();
			if (i < 3) {
				pool.execute(thread);
			} else {
				((ScheduledExecutorService) pool).schedule(thread, 2000, TimeUnit.MILLISECONDS);
			}
		}
		
		// �ر��̳߳�
		pool.shutdown();
	}

}

class MyThread extends Thread {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ��...");
	}
	
}