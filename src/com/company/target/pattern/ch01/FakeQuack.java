package com.company.target.pattern.ch01;

/**
 * �ٽ�
 */
public class FakeQuack implements QuackBehavior {
	
	@Override
	public void quack() {
		System.out.println("Qwak");
	}
	
}
