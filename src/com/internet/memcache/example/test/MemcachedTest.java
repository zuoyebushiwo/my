package com.internet.memcache.example.test;

import com.internet.memcache.example.model.Employee;
import com.internet.memcache.example.util.MemcachedUtil;

/**
 * 
 * <pre>
 * <b>����������</b>MemcachedTest ������Ӷ��󻺴棬����֤ȡ���Ļ��������Ƿ�һ�� 
 * 
 * @author ��****(Kevin.xie)<br> 
 * 
 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)
 * 
 * </pre>
 */
public class MemcachedTest {

	public static void main(String[] args) {

		MemcachedUtil cache = MemcachedUtil.getInstance();
		Employee emp = new Employee();
		emp.setCompanyName("Kevin's Company");
		emp.setDeptName("R&D Dept");
		emp.setEmpName("Kevin");

		cache.add("emp", emp);

		Employee tempEmp = (Employee) cache.get("emp");
		System.out.println("Company: " + tempEmp.getCompanyName());
		System.out.println("   Dept: " + tempEmp.getDeptName());
		System.out.println("   Name: " + tempEmp.getEmpName());
	}
}