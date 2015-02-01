package com.company.target.pattern.ch08.templatemethod.barista;

public abstract class CaffeineBeverageWithHook {

	/**
	 * 制备配方
	 */
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
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

	/**
	 * 钩子：子类自己决定要不要重写此方法
	 * 
	 * @return
	 */
	boolean customerWantsCondiments() {
		return true;
	}

}
