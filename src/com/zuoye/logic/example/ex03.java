package com.zuoye.logic.example;

//����3��  ��Ŀ����ӡ�����е� ��ˮ�ɻ��� ������ν ��ˮ�ɻ��� ����ָһ����λ�������λ���������͵��ڸ����������磺153��һ�� ��ˮ�ɻ��� ������Ϊ153=1�����η���5�����η���3�����η��� 
//
//1.�������������forѭ������100-999������ÿ�����ֽ����λ��ʮλ����λ�� 
public class ex03 {

	public static void main(String args[]) {

		int i = 0;

		Math1 myMath1 = new Math1(); 

		for (i = 100; i <= 999; i++)

			if (myMath1.shuixianhua(i) == true)

				System.out.println(i);

	}

}


