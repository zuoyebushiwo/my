package com.company.target.pattern.ch02.WeatherStation;

/**
 * 目前状况布告板
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature
				+ "F degrees and " + humidity + "% humidity");
	}

}
