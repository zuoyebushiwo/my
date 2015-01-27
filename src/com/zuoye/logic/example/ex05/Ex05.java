package com.zuoye.logic.example.ex05;

//【程序6】  题目：输入两个正整数m和n，求其最大公约数和最小公倍数。 
//
//1.程序分析：利用辗除法。 
//
//最大公约数：
public class Ex05 {

	public static void main(String args[]) {
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		
		System.out.println(a == b);
//		commonDivisor(24, 32);
	}

	static int commonDivisor(int M, int N) {
		if (N < 0 || M < 0) {
			System.out.println("ERROR!");
			return -1;
		}
		if (N == 0) {
			System.out.println("the biggest common divisor is :" + M);
			return M;
		}
		return commonDivisor(N, M % N);
	}

}
