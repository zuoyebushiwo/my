package com.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Java线程：有返回值的线程
 */
public class Test {

	public static void main(String[] args) {
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);

		// 创建两个有返回值的任务
		Callable<String> c1 = new MyCallable("A");
		Callable<String> c2 = new MyCallable("B");

		Future<String> f1 = pool.submit(c1);
		Future<String> f2 = pool.submit(c2);

		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		// 关闭线程池
		pool.shutdown();
	}

}
