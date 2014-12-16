package com.zhangxuej.thread;

public class ReadResult extends Thread {

	Calculator c;
	
	public ReadResult(Calculator c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		synchronized (c) {
			try {
				System.out.println(Thread.currentThread() + "�ȴ�������...");
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "������Ϊ��" + c.total);
		}
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		// ���������̣߳��ֱ��ȡ������
		new ReadResult(c).start();
		new ReadResult(c).start();
		new ReadResult(c).start();
		
		// ���������߳�
		c.start();
	}
	
}
