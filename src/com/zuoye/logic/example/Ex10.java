package com.zuoye.logic.example;

//������10�� ��Ŀ��һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룻�����£�������   ��10�����ʱ�������������ף���10�η�����ߣ�   
public class Ex10 {

	public static void main(String[] args) {
		
		double s = 0;
		double t = 100;
		
		for (int i = 0; i <= 10; i++) {
			s += t;
			t = t/2;
		}
		System.out.println(s);
		System.out.println(t);
	}
	
}
