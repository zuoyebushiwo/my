package com.zuoye.base.reflect;

@Author(id = "4321", name = "luan", date = "2014")
public abstract class Animal {

	private Integer age;
	private double weight;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public abstract void walk();

}
