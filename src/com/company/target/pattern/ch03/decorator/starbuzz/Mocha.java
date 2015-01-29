package com.company.target.pattern.ch03.decorator.starbuzz;

/**
 * Ä¦¿¨µ÷ÁÏ
 */
public class Mocha extends CondimentDecorator {

	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}
