package com.thread;

public class ReadResult extends Thread {

	Calculator c;

	public ReadResult(Calculator c) {
		this.c = c;
	}

	@Override
	public void run() {
		synchronized (c) {
			System.out.println(Thread.currentThread() + "�ȴ�������");
			try {
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "������Ϊ��" + c.total);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Calculator c = new Calculator();
		
		// ���������̣߳��ֱ��ȡ������
		for (int i = 0; i < 3; i++) {
			Thread t = new ReadResult(c);
			t.start();
		}
		c.start();
	}

}
