package com.zuoye.thread.high.current.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Java�̣߳��з���ֵ���߳�
 * 
 * @author hadoop
 */
public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// ����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 2; i++) {
			// �����з���ֵ������
			Callable<String> c = new MyCallable(String.valueOf(new Random().nextInt(100)));
			// ִ�����񲢻�ȡFuture����
			Future<String> f = pool.submit(c);
			System.out.println(f.get());
		}
		// �ر��̳߳�
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
		return oid + "���񷵻ص�����";
	}
	
}
