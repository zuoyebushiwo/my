package com.company.target.pattern.ch02.WeatherStation;

/**
 * 主题接口
 */
public interface Subject {
	
	/**
	 * 注册观察者
	 * 
	 * @param o
	 */
	public void registerObserver(Observer o);
	
	/**
	 * 移除观察者
	 * 
	 * @param o
	 */
	public void removeObserver(Observer o);
	
	/**
	 * 通知所有观察者
	 */
	public void notifyObservers();

}
