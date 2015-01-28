package com.company.target.collections.ch13;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

/**
 * ¼ìË÷ºÍÉ¢ÁÐÀà
 */
public class Test {

	Collection<Object> oo;
	
	Arrays arrays;
	
	TreeMap<Object, Object> treeMap;
	
	HashMap<Object, Object> hashMap;
	
	public static void main(String[] args) {
//		HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
//		hashMap.put("a", 15);
//		hashMap.put("b", 15);
//		hashMap.put("c", 15);
//		hashMap.put("d", 15);
//		System.out.println(hashMap);
		
		HashMap<Integer, String> persons = new HashMap<Integer, String>(1000);
		
		persons.put(new Integer(251), "a");
		persons.put(new Integer(118), "b");
		persons.put(new Integer(335), "c");
		
		int key = 100;
		
		int hash = new Integer(key).hashCode();
		

		String myName = "A";
		System.out.println(myName.hashCode());
		
		Integer i = 100;
		System.out.println(i.hashCode());
		
		HashSet<Object> hashSet;
		
		Iterator<Object> iterator;
		
		Vector<Object> vector;
		
		Stack<Object> stack;
		
		SortedSet<Object> sortedSet;
		
		AbstractMap<Object, Object> abstractMap;
		
	}
	
}
