package com.internet.memcache.example.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.internet.memcache.example.model.Employee;
import com.internet.memcache.example.util.MemcachedUtil;

/**
 * MemcachedUtilTest.java V1.0 2012-4-25 ����11:00:30
 * 
 * Copyright 2011 ************. All rights reserved.
 * 
 * Modification history(By Time Reason):
 * 
 * Description:
 */
public class MemcachedUtilTest {

	private Employee emp;
	private MemcachedUtil cache;

	@Before
	public void setUp() throws Exception {

		emp = new Employee();
		emp.setCompanyName("Kevin's Company");
		emp.setDeptName("R&D Dept");
		emp.setEmpName("Kevin");

		// �������
		cache = MemcachedUtil.getInstance();
		cache.add("emp", emp);

		// �����������
		cache.add("Your salary", 12345.00);
	}

	@After
	public void tearDown() throws Exception {
		// cache.remove("emp");
		// cache.remove("Your salary");
		cache = null;
		emp = null;
	}

	@Test
	public void testAddCache() {

	}

	@Test
	public void testGetCache() {

		/*
		 * �����������
		 */
		MemcachedUtil cache = MemcachedUtil.getInstance();
		System.out.println("Your salary : " + cache.get("Your salary"));
		Employee tempEmp = (Employee) cache.get("emp");

		System.out.println("Company: " + tempEmp.getCompanyName());
		System.out.println("   Dept: " + tempEmp.getDeptName());
		System.out.println("   Name: " + tempEmp.getEmpName());

		Assert.assertEquals(emp.getCompanyName(), tempEmp.getCompanyName());
	}

}
