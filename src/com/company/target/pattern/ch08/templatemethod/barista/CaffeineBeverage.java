package com.company.target.pattern.ch08.templatemethod.barista;

/**
 *  ����������
 */
public abstract class CaffeineBeverage {
	
	/**
	 * �Ʊ��䷽
	 */
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	/**
	 * ����
	 */
	abstract void brew();

	/**
	 * ��ӵ�ζƷ
	 */
	abstract void addCondiments();

	/**
	 * ��ˮ
	 */
	void boilWater() {
		System.out.println("Boiling water");
	}

	/**
	 * �����ϵ����˱���
	 */
	void pourInCup() {
		System.out.println("Pouring into cup");
	}

}
