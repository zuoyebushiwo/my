package com.zuoye.base.hashmap;

/**
 * 简单Employee Bean，重写equals方法，未重写hashcode方法
 */
public class Employee {

	private String employeeCode;
	private String name;

	public Employee(String employeeCode, String name) {
		this.employeeCode = employeeCode;
		this.name = name;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			if (this.employeeCode.equals(e.getEmployeeCode())
					&& name.equals(e.getName())) {
				return true;
			}
		}
		return false;
	}

}
