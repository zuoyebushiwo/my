package com.company.target.collections.ch03;

/**
 * �򵥵ݹ飺
 * 		ʵ��10����ת��Ϊ2����
 */
public class WriteBinary {
	
	public static void main(String[] args) {
		WriteBinary writeBinary = new WriteBinary();
		writeBinary.writer(2);
	}

	public void writer(int n) {
		if (n <= 1) {
			System.out.println(n);
		} else {
			writer(n / 2);
			System.out.println(n % 2);
		}
	}
	
}
