package com.zuoye.thread.high;


public class Test {
	
	public static void main(String[] args) {
		
		User u = new User("����", 100);
		MyThread t1 = new MyThread("�߳�A", u, 20);
		MyThread t2 = new MyThread("�߳�B", u, -60);
		MyThread t3 = new MyThread("�߳�C", u, -80);
		MyThread t4 = new MyThread("�߳�D", u, -30);
		MyThread t5 = new MyThread("�߳�E", u, 32);
		MyThread t6 = new MyThread("�߳�F", u, 21);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}

}
