package com.company.target.pattern.ch02.WeatherStation;

/**
 * �ӿڣ��۲���
 */
public interface Observer {

	/**
	 * �������й۲����е���ϸ����
	 * 
	 * @param temp
	 *            �¶�
	 * @param humidity
	 *            �ʶ�
	 * @param pressure
	 *            ��ѹ
	 */
	public void update(float temperature, float humidity, float pressure);

}
