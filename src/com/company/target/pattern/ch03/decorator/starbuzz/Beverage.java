package com.company.target.pattern.ch03.decorator.starbuzz;

/**
 * 抽象基类：
 * 			饮料
 */
public abstract class Beverage {

	String description = "Unkown Beverage";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
	
}
