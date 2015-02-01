package com.company.target.pattern.ch08.templatemethod.barista;

public abstract class CaffeineBeverageWithHook {

	/**
	 * �Ʊ��䷽
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

	/**
	 * ���ӣ������Լ�����Ҫ��Ҫ��д�˷���
	 * 
	 * @return
	 */
	boolean customerWantsCondiments() {
		return true;
	}

}
