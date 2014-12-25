package com.thread;


public class Play  {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			Thread good = new Thread(new GoodWord());
			Thread nice = new Thread(new NiceWord(good));
			good.start();
			nice.start();
		}
		
	}
}

class GoodWord implements Runnable {

	@Override
	public void run() {
		System.out.println("good");
	}
	
}

class NiceWord implements Runnable {

	Thread good;
	
	public NiceWord(Thread good) {
		this.good = good;
	}

	@Override
	public void run() {
		try {
			good.join();
			System.out.println("nice");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}