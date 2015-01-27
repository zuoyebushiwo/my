package com.thread;

/**
 * Java线程：线程的调度-合并 
 */
public class Test {
	
	public static void main(String[] args) {
		
		Thread t1 = new MyThread();
		t1.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("主线程第" + i + "次运行！");
			if (i > 2) {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
