package com.company.target.pattern.ch01;

/**
 * �ư�
 */
public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}

}
