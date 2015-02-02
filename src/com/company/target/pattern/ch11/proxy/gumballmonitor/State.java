package com.company.target.pattern.ch11.proxy.gumballmonitor;

/**
 * 状态接口
 */
public interface State {
	
	/**
	 * 放入硬币
	 */
	public void insertQuarter();
	
	/**
	 * 去除剩余硬币
	 */
	public void ejectQuarter();
	
	/**
	 * 转动曲柄
	 */
	public void turnCrank();
	
	/**
	 * 发放糖果
	 */
	public void dispense();

}
