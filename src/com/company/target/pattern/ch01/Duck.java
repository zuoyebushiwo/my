package com.company.target.pattern.ch01;

/**
 * 鸭子积累
 */
public abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public Duck() {

	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	/**
	 * 鸭子样式
	 */
	abstract void display();

	/**
	 * 调用飞行行为
	 */
	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}

}
