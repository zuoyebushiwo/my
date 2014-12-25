package com.zhangxuej.thread;

public class MyRunnable implements Runnable {

	private Foo foo = new Foo();

	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread ta = new Thread(r, "Thread-A");
		Thread tb = new Thread(r, "Thread-B" );
		ta.start();
		tb.start();
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				synchronized (foo) {
					this.fix(30);
					Thread.sleep(1);
					System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值=" + foo.getX());
				}
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int fix(int y) {
		return foo.fix(y);
	}

	// public static void main(String[] args) {

	// Foo foo = new Foo(100);
	//
	// Thread a = new ThreadA(foo);
	// Thread b = new ThreadB(foo);
	//
	// a.start();
	// b.start();
	//
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// System.out.println(foo.i);

	// }

}

class Foo {

	// int i;
	//
	// public Foo(int i) {
	// this.i = i;
	// }
	//
	// public synchronized void add() {
	// i++;
	// }
	//
	// public synchronized void sub() {
	// i--;
	// }

	private int x = 100;

	public int getX() {
		return x;
	}

	public int fix(int y) {
		x = x - y;
		return x;
	}

}

class ThreadA extends Thread {

	private Foo foo;

	public ThreadA(Foo foo) {
		this.foo = foo;
	}

	@Override
	public void run() {
//		foo.add();
	}

}

class ThreadB extends Thread {

	private Foo foo;

	public ThreadB(Foo foo) {
		this.foo = foo;
	}

	@Override
	public void run() {
//		foo.sub();
	}

}