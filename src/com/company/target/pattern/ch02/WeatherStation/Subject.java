package com.company.target.pattern.ch02.WeatherStation;

/**
 * ����ӿ�
 */
public interface Subject {
	
	/**
	 * ע��۲���
	 * 
	 * @param o
	 */
	public void registerObserver(Observer o);
	
	/**
	 * �Ƴ��۲���
	 * 
	 * @param o
	 */
	public void removeObserver(Observer o);
	
	/**
	 * ֪ͨ���й۲���
	 */
	public void notifyObservers();

}
