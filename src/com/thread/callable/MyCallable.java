package com.thread.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	private String oid;
	
	public MyCallable(String oid) {
		this.oid = oid;
	}

	@Override
	public String call() throws Exception {
		return Thread.currentThread().getName() + " " + oid;
	}

}
