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
				System.out.println(Thread.currentThread() + "等待计算结果...");
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "计算结果为：" + c.total);
		}
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		// 启动三个线程，分别获取计算结果
		new ReadResult(c).start();
		new ReadResult(c).start();
		new ReadResult(c).start();
		
		// 启动计算线程
		c.start();
	}
	
}
