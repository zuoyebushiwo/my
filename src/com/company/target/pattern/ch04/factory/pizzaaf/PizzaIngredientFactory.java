package com.company.target.pattern.ch04.factory.pizzaaf;

/**
 * �ӿڣ����𴴽����е�ԭ��
 */
public interface PizzaIngredientFactory {

	/**
	 * ��������
	 * 
	 * @return
	 */
	public Dough createDough();

	/**
	 * ��������
	 * 
	 * @return
	 */
	public Sauce createSauce();

	/**
	 * ��������
	 * 
	 * @return
	 */
	public Cheese createCheese();

	/**
	 * �����߲�
	 * 
	 * @return
	 */
	public Veggies[] createVeggies();

	/**
	 * �����㳦
	 * 
	 * @return
	 */
	public Pepperoni createPepperoni();

	/**
	 * ��������
	 * 
	 * @return
	 */
	public Clams createClam();

}
