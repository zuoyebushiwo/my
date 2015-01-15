package com.iq;

public class Test01 {

	// 第1种办法
//	public void changeMethodA(int a, int b){
//        System.out.println("changeMethodA交换之前\ta:"+a+"\tb:"+b);
//        a = a + b – (b = a);
//        System.out.println("changeMethodA交换之后\ta:"+a+"\tb:"+b);
//    }

	// 第2种办法
	public void changeMethodB(int a, int b) {
		System.out.println("changeMethodB交换之前\ta:" + a + "\tb:" + b);
		b = a + (a = b) * 0;
		System.out.println("changeMethodB交换之后\ta:" + a + "\tb:" + b);
	}

	// 第3种办法
//	public void changeMethodC(int a, int b){
//        System.out.println("changeMethodC交换之前\ta:"+a+"\tb:"+b);
//        a = a + b;
//        b = a – b;
//        a = a – b;
//        System.out.println("changeMethodC交换之后\ta:"+a+"\tb:"+b);
//    }

	// 第4种办法
	public void changeMethodD(int a, int b) {
		System.out.println("changeMethodD交换之前\ta:" + a + "\tb:" + b);
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println("changeMethodD交换之后\ta:" + a + "\tb:" + b);
	}

	// 第5种办法
	public void changeMethodE(int a, int b) {
		System.out.println("changeMethodE交换之前\ta:" + a + "\tb:" + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("changeMethodE交换之后\ta:" + a + "\tb:" + b);
	}
	
	public static void main(String[] args) {
		new Test01().changeMethodB(5, 2);
	}
	
}
