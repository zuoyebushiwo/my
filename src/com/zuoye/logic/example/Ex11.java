package com.zuoye.logic.example;

//������11��   ��Ŀ����1��2��3��4�����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�   
//1.��������������ڰ�λ��ʮλ����λ�����ֶ���1��2��3��4��������е����к���ȥ   �����������������С�  
public class Ex11 {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int k = 0;
		int t = 0;

		for (j = 1; j <= 4; j++)
			for (k = 1; k <= 4; k++)
				if (i != j && j != k && i != k) {
					t += 1;
					System.out.println(i * 100 + j * 10 + k);
				}
		System.out.println(t);

	}

}
