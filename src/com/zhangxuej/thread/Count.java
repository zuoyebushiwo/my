package com.zhangxuej.thread;

public class Count extends Thread {

	public static void main(String[] args) {
		Thread count = new Count();
		count.start();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			for (int i = 0; i < 101; i++) {
				Thread.currentThread().sleep(1000);
				if (i % 10 == 0 && i > 0) {
					System.out.println(i);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
