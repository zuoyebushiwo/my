package com.iq;

public class Test01 {

	// ��1�ְ취
//	public void changeMethodA(int a, int b){
//        System.out.println("changeMethodA����֮ǰ\ta:"+a+"\tb:"+b);
//        a = a + b �C (b = a);
//        System.out.println("changeMethodA����֮��\ta:"+a+"\tb:"+b);
//    }

	// ��2�ְ취
	public void changeMethodB(int a, int b) {
		System.out.println("changeMethodB����֮ǰ\ta:" + a + "\tb:" + b);
		b = a + (a = b) * 0;
		System.out.println("changeMethodB����֮��\ta:" + a + "\tb:" + b);
	}

	// ��3�ְ취
//	public void changeMethodC(int a, int b){
//        System.out.println("changeMethodC����֮ǰ\ta:"+a+"\tb:"+b);
//        a = a + b;
//        b = a �C b;
//        a = a �C b;
//        System.out.println("changeMethodC����֮��\ta:"+a+"\tb:"+b);
//    }

	// ��4�ְ취
	public void changeMethodD(int a, int b) {
		System.out.println("changeMethodD����֮ǰ\ta:" + a + "\tb:" + b);
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println("changeMethodD����֮��\ta:" + a + "\tb:" + b);
	}

	// ��5�ְ취
	public void changeMethodE(int a, int b) {
		System.out.println("changeMethodE����֮ǰ\ta:" + a + "\tb:" + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("changeMethodE����֮��\ta:" + a + "\tb:" + b);
	}
	
	public static void main(String[] args) {
		new Test01().changeMethodB(5, 2);
	}
	
}
