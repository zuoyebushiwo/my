package com.zuoye.logic.example;

//������16�� ��Ŀ�����9*9�ھ���   
//1.����������������п��ǣ���9��9�У�i�����У�j�����С�  
public class Ex16 {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				sb.append(i + "*" + j + "=" + i * j + "\t");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
