package com.company.target.pattern.ch04.factory.pizzaaf;

/**
 * 接口：负责创建所有的原料
 */
public interface PizzaIngredientFactory {

	/**
	 * 创建面团
	 * 
	 * @return
	 */
	public Dough createDough();

	/**
	 * 创建酱料
	 * 
	 * @return
	 */
	public Sauce createSauce();

	/**
	 * 创建奶酪
	 * 
	 * @return
	 */
	public Cheese createCheese();

	/**
	 * 创建蔬菜
	 * 
	 * @return
	 */
	public Veggies[] createVeggies();

	/**
	 * 创建香肠
	 * 
	 * @return
	 */
	public Pepperoni createPepperoni();

	/**
	 * 创建蛤蜊
	 * 
	 * @return
	 */
	public Clams createClam();

}
