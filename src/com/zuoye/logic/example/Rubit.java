package com.zuoye.logic.example;

public class Rubit {

	public static void main(String[] args) {
		int i = 0;
		
		for (i = 1; i <= 20; i++) {
			System.out.println(f(i));
		}
	}

	private static int f(int x) {
		if (x == 1 || x == 2) {
			return 1;
		} else {
			return f(x -1) + f(x -2);
		}
	}
}
