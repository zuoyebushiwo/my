package com.zhangxuej.thread.high.producerconsumer;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Storage storage = new Storage(30);
		for (int i = 0; i < 5; i++) {
			Producer p = new Producer(storage, new Random().nextInt(50));
			p.start();
		}
		for (int i = 0; i < 10; i++) {
			Consumer c = new Consumer(storage, new Random().nextInt(30));
			c.start();
		}
	}
	
}
