package com.internet.memcache.example.model;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5043942473561619430L;

	/**
	 * 员工名字
	 */
	private String EmpName;

	/**
	 * 部门名
	 */
	private String deptName;

	/**
	 * 公司名
	 */
	private String companyName;

	/**
	 * 
	 * <b>构造函数：</b>
	 * 
	 */
	public Employee() {

	}

	/**
	 * Access method for the empName property
	 * 
	 * @return the empName
	 */
	public String getEmpName() {

		return EmpName;
	}

	/**
	 * Sets the value of empName the property
	 * 
	 * @param empName
	 *            the empName to set
	 */
	public void setEmpName(String empName) {

		EmpName = empName;
	}

	/**
	 * Access method for the deptName property
	 * 
	 * @return the deptName
	 */
	public String getDeptName() {

		return deptName;
	}

	/**
	 * Sets the value of deptName the property
	 * 
	 * @param deptName
	 *            the deptName to set
	 */
	public void setDeptName(String deptName) {

		this.deptName = deptName;
	}

	/**
	 * Access method for the companyName property
	 * 
	 * @return the companyName
	 */
	public String getCompanyName() {

		return companyName;
	}

	/**
	 * Sets the value of companyName the property
	 * 
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {

		this.companyName = companyName;
	}

}
