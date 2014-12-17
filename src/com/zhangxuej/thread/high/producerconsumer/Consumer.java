package com.zhangxuej.thread.high.producerconsumer;

/**
 * Ïû·ÑÕß
 * 
 * @author hadoop
 */
public class Consumer extends Thread {
	
	private Storage storage;
	private int oper;
	
	public Consumer(Storage storage, int oper) {
		this.storage = storage;
		this.oper = oper;
	}
	
	@Override
	public void run() {
		try {
			storage.consumer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
