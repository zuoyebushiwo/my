package com.zhangxuej.thread.high.producerconsumer;

/**
 * ЩњВњеп
 * 
 * @author hadoop
 */
public class Producer extends Thread {

	private Storage storage;
	private int oper;
	
	public Producer(Storage storage, int oper) {
		this.storage = storage;
		this.oper = oper;
	}
	
	@Override
	public void run() {
		try {
			storage.producer(oper);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
