package com.company.target.pattern.ch10.gumballstate;

/**
 * ״̬�ӿ�
 */
public interface State {
	
	/**
	 * ����Ӳ��
	 */
	public void insertQuarter();
	
	/**
	 * ȥ��ʣ��Ӳ��
	 */
	public void ejectQuarter();
	
	/**
	 * ת������
	 */
	public void turnCrank();
	
	/**
	 * �����ǹ�
	 */
	public void dispense();

}