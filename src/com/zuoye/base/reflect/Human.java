package com.zuoye.base.reflect;

//ע������  
@Author(id = "1234", name = "louis", date = "2014")
@Function(value = "������ඨ��")
public class Human extends Animal implements Inventor {

	// ��Ա������ Fields
	private String name;
	private String color;
	private String nationality;
	public String birthDate;

	// ���������� Constructor
	public Human() {
	}

	private Human(String name) {
		this.name = name;
	}

	@Function(value = "��������������������")
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

	// ��������
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
		System.out.println("���෢������������");
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
