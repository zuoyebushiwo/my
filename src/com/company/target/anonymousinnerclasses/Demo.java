package com.company.target.anonymousinnerclasses;

/**
 * �����ڲ���:
 * 
 * 		�����ڲ���Ҳ����û�����ֵ��ڲ���
 * 		����Ϊû�����֣����������ڲ���ֻ��ʹ��һ�Σ���ͨ�����ڼ򻯴����д
 * 		��ʹ�������ڲ��໹�и�ǰ������������̳�һ�������ʵ��һ���ӿ�
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