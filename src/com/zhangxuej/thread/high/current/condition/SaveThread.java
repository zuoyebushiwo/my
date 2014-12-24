package com.zhangxuej.thread.high.current.condition;

/**
 * ����߳���
 */
public class SaveThread extends Thread {

	private String name; // ������
	private MyCount myCount; // �˻�
	private int x; // �����

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
