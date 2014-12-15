package com.zhangxuej.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		final NameList nl = new NameList();
		nl.add("zhangxuej");

		class NameDropper extends Thread {
			@Override
			public void run() {
				String name = nl.removeFirst();
				System.out.println(name);
			}
		}
		
		Thread t1 = new NameDropper();
		Thread t2 = new NameDropper();
		
		t1.start();
		t2.start();
	}

}

class NameList {

	private List<String> nameList = Collections
			.synchronizedList(new LinkedList<String>());

	public void add(String name) {
		nameList.add(name);
	}

	public String removeFirst() {
		if (nameList.size() > 0) {
			return nameList.remove(0);
		} else {
			return null;
		}
	}

}