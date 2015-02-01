package com.company.target.pattern.ch08.templatemethod.barista;

/**
 *  咖啡因饮料
 */
public abstract class CaffeineBeverage {
	
	/**
	 * 制备配方
	 */
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	/**
	 * 冲泡
	 */
	abstract void brew();

	/**
	 * 添加调味品
	 */
	abstract void addCondiments();

	/**
	 * 煮水
	 */
	void boilWater() {
		System.out.println("Boiling water");
	}

	/**
	 * 将饮料倒入了杯子
	 */
	void pourInCup() {
		System.out.println("Pouring into cup");
	}

}
