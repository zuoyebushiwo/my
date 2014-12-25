package com.zuoye.thread.high.current.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Java线程：有返回值的线程
 * 
 * @author hadoop
 */
public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 2; i++) {
			// 创建有返回值的任务
			Callable<String> c = new MyCallable(String.valueOf(new Random().nextInt(100)));
			// 执行任务并获取Future对象
			Future<String> f = pool.submit(c);
			System.out.println(f.get());
		}
		// 关闭线程池
		pool.shutdown();
	}
	
}

class MyCallable implements Callable<String> {

	private String oid;
	
	public MyCallable(String oid) {
		this.oid = oid;
	}
	
	@Override
	public String call() throws Exception {
		return oid + "任务返回的内容";
	}
	
}
