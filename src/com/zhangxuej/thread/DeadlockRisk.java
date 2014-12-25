package com.zhangxuej.thread;

/**
 * À¿À¯
 * 
 * @author hadoop
 */
public class DeadlockRisk {

	private static class Resource {
		public int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();

	public int read() {
		synchronized (resourceA) {
			synchronized (resourceB) {
				return resourceA.value + resourceB.value;
			}
		}
	}

	public void write(int a, int b) {
		synchronized (resourceB) {
			synchronized (resourceA) {
				resourceA.value = a;
				resourceB.value = b;
			}
		}
	}

	public static void main(String[] args) {

		DeadlockRisk deadlockRisk = new DeadlockRisk();
		
		Thread read = new ReadThread(deadlockRisk);
		Thread write = new WriteThread(deadlockRisk);
		
		read.start();
		write.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ReadThread extends Thread {
	
	DeadlockRisk deadlockRisk;
	
	public ReadThread(DeadlockRisk deadlockRisk) {
		this.deadlockRisk = deadlockRisk;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			deadlockRisk.read();
			System.out.println(i);
		}
	}
	
}

class WriteThread extends Thread {
	
	DeadlockRisk deadlockRisk;
	
	public WriteThread(DeadlockRisk deadlockRisk) {
		this.deadlockRisk = deadlockRisk;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			deadlockRisk.write(100, 20);
			System.out.println(i);
		}
	}
	
}
