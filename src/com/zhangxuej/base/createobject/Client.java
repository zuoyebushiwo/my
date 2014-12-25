package com.zhangxuej.base.createobject;

public class Client {

	public static void main(String[] args) {
		Worker worker = CreateInstanceUtil.createWorker2();
		worker = CreateInstanceUtil.createWorker3("zhangxuej", 25);
		System.out.println("");
	}
	
}
