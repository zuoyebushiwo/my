package com.zhangxuej.thread.high;

public class MyThread extends Thread {
	
	private User u;
	private int y = 0;
	
	public MyThread(String name, User u, int y) {
		super(name);
		this.u = u;
		this.y = y;
	}
	
	@Override
	public void run() {
		u.oper(y);
	}

}
