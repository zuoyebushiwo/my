package com.zuoye.logic.example;

import java.util.Scanner;

//������12��  ��Ŀ����ҵ���ŵĽ������������ɡ�����(I)���ڻ����10��Ԫʱ���������10%���������10��Ԫ������20��Ԫʱ������10��Ԫ�Ĳ��ְ�10%��ɣ�����10��Ԫ�Ĳ��֣��ɿ����7.5%��20��40��֮��ʱ������20��Ԫ�Ĳ��֣������5%��40��60��֮��ʱ����40��Ԫ�Ĳ��֣������3%��60��100��֮��ʱ������60��Ԫ�Ĳ��֣������1.5%������100��Ԫʱ������100��Ԫ�Ĳ��ְ�1%��ɣ��Ӽ������뵱������I����Ӧ���Ž���������   
//1.����������������������ֽ磬��λ��ע�ⶨ��ʱ��ѽ�����ɳ����͡�   
public class Ex12 {

	public static void main(String[] args) {
		double sum;// ����Ҫ����ı���Ӧ���Ľ���
		Scanner input = new Scanner(System.in);
		System.out.println("���뵱������");
		double lirun = input.nextDouble();

		if (lirun <= 100000) {
			sum = lirun * 0.1;
		} else if (lirun <= 200000) {
			sum = 10000 + lirun * 0.075;
		} else if (lirun <= 400000) {
			sum = 17500 + lirun * 0.05;
		} else if (lirun <= 600000) {
			sum = lirun * 0.03;
		} else if (lirun <= 1000000) {
			sum = lirun * 0.015;
		} else {
			sum = lirun * 0.01;
		}
		System.out.println("Ӧ���Ľ�����" + sum);
	}

}
