package com.zuoye.base.hashmap;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		
		Employee em1= new Employee("123","louis");  
        Employee em2= new Employee("123","louis");  
        
        boolean equals = em1.equals(em2);
        
        System.out.println("em1 equals em2 ? " +equals); 
        HashMap<Employee, String> map = new HashMap<Employee, String>();  
        map.put(em1, "test1");  
        map.put(em2, "test2");  
        System.out.println("map size:"+map.size());  
		
	}
	
}
