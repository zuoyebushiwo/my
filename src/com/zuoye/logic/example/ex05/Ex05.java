package com.zuoye.logic.example.ex05;

//������6��  ��Ŀ����������������m��n���������Լ������С�������� 
//
//1.�������������շ������ 
//
//���Լ����
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
