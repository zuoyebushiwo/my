package com.zuoye.base.createobject;

public class Client {

	public static void main(String[] args) {
		Worker worker = CreateInstanceUtil.createWorker2();
		worker = CreateInstanceUtil.createWorker3("zuoye", 25);
		worker = CreateInstanceUtil.createWorker3("zuoye", 25);
		System.out.println("");
	}
	
}
