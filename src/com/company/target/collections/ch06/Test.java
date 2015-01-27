package com.company.target.collections.ch06;

import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
	
	public static void main(String[] args) {
		LinkedList<Object> linkedList = new LinkedList<Object>();
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");
		linkedList.add("d");
		linkedList.add("e");
		
		ListIterator<Object> iterator = linkedList.listIterator();
		
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//		
//		while (iterator.hasPrevious()) {
//			System.out.println(iterator.previous());
//		}
		
		System.out.println(iterator.next() + " " + iterator.next() + " " + iterator.previous());
		
		
	}

}
