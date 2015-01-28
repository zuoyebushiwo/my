package com.company.target.pattern.ch01;

/**
 * 不可飞行类
 */
public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't fly ");
	}

}
