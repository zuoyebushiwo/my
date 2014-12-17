package com.zhangxuej.thread.high.producerconsumer;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Storage storage = new Storage();
		for (int i = 0; i < 2; i++) {
			Producer p = new Producer(storage, new Random().nextInt(5));
			p.start();
		}
		for (int i = 0; i < 10; i++) {
			Consumer c = new Consumer(storage, new Random().nextInt(5));
			c.start();
		}
	}
	
}
