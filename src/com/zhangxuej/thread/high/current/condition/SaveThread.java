package com.zhangxuej.thread.high.current.condition;

/**
 * 存款线程类
 */
public class SaveThread extends Thread {

	private String name; // 操作人
	private MyCount myCount; // 账户
	private int x; // 存款金额

	public SaveThread(String name, MyCount myCount, int x) {
		this.name = name;
		this.myCount = myCount;
		this.x = x;
	}
	
	@Override
	public void run() {
		myCount.saving(x, name);
	}

}
