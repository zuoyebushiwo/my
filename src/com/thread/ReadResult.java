package com.thread;

public class ReadResult extends Thread {

	Calculator c;

	public ReadResult(Calculator c) {
		this.c = c;
	}

	@Override
	public void run() {
		synchronized (c) {
			System.out.println(Thread.currentThread() + "等待计算结果");
			try {
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "计算结果为：" + c.total);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Calculator c = new Calculator();
		
		// 启动三个线程，分别获取计算结果
		for (int i = 0; i < 3; i++) {
			Thread t = new ReadResult(c);
			t.start();
		}
		c.start();
	}

}
