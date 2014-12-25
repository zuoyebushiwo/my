package com.zhangxuej.base.createobject;

import java.io.Serializable;

/**
 * @author zhangxuej
 */
public class Worker implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	
	public Worker() {
		this.name = "";
		this.age = 0;
	}
	
	public Worker(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public void work() {
		System.out.println(name + "is working");
	}
	
	@Override
	protected Object clone() {
		Worker worker = null;
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return worker;
	}
	
}
