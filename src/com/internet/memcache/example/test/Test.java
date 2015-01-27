package com.internet.memcache.example.test;

import java.util.ArrayList;
import java.util.List;


public class Test {

	public static void deXX() {

	}
}

class MyTest extends Test {
	
	
	
	public static void deXX() {
		
		List<?> listOfAnyType;

		List<Object> listOfObject = new ArrayList<Object>();

		List<String> listOfString = new ArrayList<String>();

		List<Integer> listOfInteger = new ArrayList<Integer>();

		listOfAnyType = listOfString; //legal

		listOfAnyType = listOfInteger; //legal

		listOfAnyType = listOfString; //compiler error ¨C in-convertible types
		
	}
}