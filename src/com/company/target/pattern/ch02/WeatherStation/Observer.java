package com.company.target.pattern.ch02.WeatherStation;

/**
 * 接口：观察者
 */
public interface Observer {

	/**
	 * 更新所有观察者中的明细数据
	 * 
	 * @param temp
	 *            温度
	 * @param humidity
	 *            适度
	 * @param pressure
	 *            气压
	 */
	public void update(float temperature, float humidity, float pressure);

}
