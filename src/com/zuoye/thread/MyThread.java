package com.zuoye.thread;

public class MyThread {

	public static void main(String[] args) {

		Food foo = new Food(100);
		Thread a = new ThreadTA(foo);
		Thread b = new ThreadTB(foo);
		a.start();
		b.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(foo.i);

	}
}

class Food {

	int i;

	public Food(int i) {
		this.i = i;
	}

	public synchronized int getI() {
		return i;
	}
	
	public synchronized int add() {
		return i++;
	}

	public synchronized int sub() {
		return i--;
	}

}

class ThreadTA extends Thread {

	private Food foo;

	public ThreadTA(Food foo) {
		this.foo = foo;
	}

	@Override
	public void run() {
		int j = Math.round(10);
		System.out.println("Aj:" + j);
		for (int i = 0; i < j; i++) {
			foo.add();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("¼Ó1		" + foo.getI());
		}
	}

}

class ThreadTB extends Thread {

	private Food foo;

	public ThreadTB(Food foo) {
		this.foo = foo;
	}

	@Override
	public void run() {
		int j = Math.round(20);
		System.out.println("Bj:" + j);
		for (int i = 0; i < j; i++) {
			foo.sub();
			try {
				Thread.sleep(1);
				System.out.println("¼õ1		" + foo.getI());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}