package com.zuoye.thread;

/**
 * @author hadoop
 *
 */
public class JoinTest {

	public static void main(String[] args) {
		
		Thread a = new A();
		a.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("���߳����е�" + i + "�Σ�");
			if (i > 2) {
				try {
					a.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

class A extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�߳�A���е�" + i + "�Σ�");
		}
	}
	
}