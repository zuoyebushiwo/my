package com.company.target.pattern.ch01;

/**
 * ¼Ù½Ð
 */
public class FakeQuack implements QuackBehavior {
	
	@Override
	public void quack() {
		System.out.println("Qwak");
	}
	
}
