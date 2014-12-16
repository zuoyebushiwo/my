package com.zhangxuej.thread;

/**
 * Java线程：线程的调度和让步
 * 
 * @author hadoop
 */
public class YieldTest {
	
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new Thread(new MyRunnable1());
		
		t1.start();
		t2.start();
	}

}

class MyThread1 extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程1第"+i+"次运行！");
		}
	}
}

class MyRunnable1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程2第"+i+"次执行！");
			Thread.yield();
		}
	}
	
}