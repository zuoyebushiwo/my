package com.zuoye.logic.example;

//������13��   
//��Ŀ��һ��������������100����һ����ȫƽ����������168����һ����ȫƽ���������ʸ����Ƕ��٣�   
//1.�����������10�������жϣ��Ƚ���������100���ٿ������ٽ���������268���ٿ��������������Ľ�������������������ǽ�����뿴���������   
public class Ex13 {

	public static void main(String[] args) {

		long k = 0;
		for (int i = 1; k <= 100000001; i++) {
			if (Math.floor(Math.sqrt(k + 100)) == Math.sqrt(k + 100)
					&& Math.floor(Math.sqrt(k + 168)) == Math.sqrt(k + 168))
				System.out.println(k);
		}

	}

}
