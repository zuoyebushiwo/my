package com.zuoye.thread.high.current.condition;

/**
 * ȡ���߳���
 */
public class DrawThread extends Thread {

	private String name; // ������
	private MyCount myCount; // �˻�
	private int x; // �����
	
	public DrawThread(String name, MyCount myCount, int x) {
		this.name = name;
		this.myCount = myCount;
		this.x = x;
	}
	
	@Override
	public void run() {
		myCount.drawing(x, name);
	}
	
}
