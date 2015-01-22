package com.company.target.anonymousinnerclasses;

/**
 * 匿名内部类:
 * 
 * 		匿名内部类也就是没有名字的内部类
 * 		正因为没有名字，所以匿名内部类只能使用一次，它通常用于简化代码编写
 * 		但使用匿名内部类还有个前提条件：必须继承一个父类或实现一个接口
 */
public class Demo {

	public static void main(String[] args) {
//		Person p = new Child();
//		p.eat();
		
		Person p = new Person() {
			@Override
			public void eat() {
				System.out.println("do something");
			}
		};
		p.eat();
		
	}
	
}

abstract class Person {
	public abstract void eat();
}

class Child extends Person {

	@Override
	public void eat() {
		System.out.println("eat something");
	}
	
}