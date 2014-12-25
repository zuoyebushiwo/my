package com.zhangxuej.thread;

/**
 * Java�̣߳��̵߳ĵ��Ⱥ��ò�
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
			System.out.println("�߳�1��"+i+"�����У�");
		}
	}
}

class MyRunnable1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�߳�2��"+i+"��ִ�У�");
			Thread.yield();
		}
	}
	
}