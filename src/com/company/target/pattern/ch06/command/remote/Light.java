package com.company.target.pattern.ch06.command.remote;

/**
 * 电灯：
 * 		各个地方的灯
 */
public class Light {
	String location = "";

	public Light(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " light is on");
	}

	public void off() {
		System.out.println(location + " light is off");
	}
}
