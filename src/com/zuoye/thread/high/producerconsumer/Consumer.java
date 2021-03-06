package com.zuoye.thread.high.producerconsumer;

/**
 * ������
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
			storage.consumer(oper);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
