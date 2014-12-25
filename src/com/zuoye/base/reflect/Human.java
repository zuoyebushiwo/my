package com.zuoye.base.reflect;

//注解区域  
@Author(id = "1234", name = "louis", date = "2014")
@Function(value = "人类的类定义")
public class Human extends Animal implements Inventor {

	// 成员变量区 Fields
	private String name;
	private String color;
	private String nationality;
	public String birthDate;

	// 构造器部分 Constructor
	public Human() {
	}

	private Human(String name) {
		this.name = name;
	}

	@Function(value = "构造器，带有三个参数")
	public Human(String name, String color, String nationality)
			throws Exception {
		this(name);
		this.color = color;
		this.nationality = nationality;
	}

	public Human(String name, String color, String nationality, String birthDate)
			throws Exception {
		this(name, color, nationality);
		this.birthDate = birthDate;
	}

	// 方法区域
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void invent() {
		System.out.println("人类发明。。。。。");
	}

	@Override
	public void walk() {
		System.out.println("Using two legs");
	}

	@Author(id = "123", name = "luan", date = "2014")
	public void speak() {
		System.out.println("You are in " + nationality + ",You can speak "
				+ nationality);
	}

	class Mind {
	}

}
