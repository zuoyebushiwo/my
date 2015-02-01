package com.company.target.pattern.ch01;

/**
 * ��ͷѼ
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	void display() {
		System.out.println("I'm a real Mallard duck");
	}

}
