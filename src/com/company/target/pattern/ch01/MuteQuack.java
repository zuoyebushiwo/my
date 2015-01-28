package com.company.target.pattern.ch01;

/**
 * ÑÆ°Í
 */
public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}

}
