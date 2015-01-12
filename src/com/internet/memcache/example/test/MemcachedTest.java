package com.internet.memcache.example.test;

import com.internet.memcache.example.model.Employee;
import com.internet.memcache.example.util.MemcachedUtil;

/**
 * 
 * <pre>
 * <b>功能描述：</b>MemcachedTest 测试添加对象缓存，比验证取出的缓存数据是否一致 
 * 
 * @author ：****(Kevin.xie)<br> 
 * 
 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容)
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