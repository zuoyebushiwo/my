package com.zuoye.logic.example;

//【程序16】 题目：输出9*9口诀。   
//1.程序分析：分行与列考虑，共9行9列，i控制行，j控制列。  
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
