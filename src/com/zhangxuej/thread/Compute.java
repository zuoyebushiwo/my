package com.zhangxuej.thread;

public class Compute {

	public static void main(String[] args) throws InterruptedException {
		Amount amount = new Amount();
		
		for (int i = 0; i < 2; i++) {
			Thread addThread = new AddThread(amount);
			Thread subThread = new SubThread(amount);
			addThread.start();
			subThread.start();
			
			addThread.join();
			subThread.join();
		}
		System.out.println(amount.i);
	}

}

class Amount {

	public int i = 100;

	public synchronized void add() {
		i +=2;
	}

	public synchronized void sub() {
		i--;
	}

}

class AddThread extends Thread {

	private Amount amount;

	public AddThread(Amount amount) {
		this.amount = amount;
	}

	@Override
	public void run() {
		amount.add();
	}

}

class SubThread extends Thread {

	private Amount amount;

	public SubThread(Amount amount) {
		this.amount = amount;
	}

	@Override
	public void run() {
		amount.sub();
	}

}