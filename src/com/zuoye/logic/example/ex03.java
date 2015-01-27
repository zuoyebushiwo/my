package com.zuoye.logic.example;

//程序3】  题目：打印出所有的 “水仙花数 “，所谓 “水仙花数 “是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 “水仙花数 “，因为153=1的三次方＋5的三次方＋3的三次方。 
//
//1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。 
public class ex03 {

	public static void main(String args[]) {

		int i = 0;

		Math1 myMath1 = new Math1(); 

		for (i = 100; i <= 999; i++)

			if (myMath1.shuixianhua(i) == true)

				System.out.println(i);

	}

}


