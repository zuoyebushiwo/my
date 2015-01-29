package com.company.target.pattern.ch03.decorator.starbuzz;

/**
 * ������ࣺ
 * 			����
 */
public abstract class Beverage {

	String description = "Unkown Beverage";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
	
}
