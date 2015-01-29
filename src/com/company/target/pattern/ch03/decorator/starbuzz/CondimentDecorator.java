package com.company.target.pattern.ch03.decorator.starbuzz;

/**
 * 抽象类基类：
 * 			调料
 * 
 * 装饰者类
 */
public abstract class CondimentDecorator extends Beverage {

	@Override
	public abstract String getDescription();
	
}
