package com.zuoye.logic.example;

//������17��   ��Ŀ�����ӳ������⣺���ӵ�һ��ժ�����ɸ����ӣ���������һ�룬����񫣬�ֶ����һ��   
//�ڶ��������ֽ�ʣ�µ����ӳԵ�һ�룬�ֶ����һ�����Ժ�ÿ�����϶�����ǰһ��ʣ��   ��һ����һ��������10���������ٳ�ʱ����ֻʣ��һ�������ˡ����һ�칲ժ�˶��١�   
//1.�����������ȡ����˼ά�ķ������Ӻ���ǰ�ƶϡ� 
public class Ex17 {

	public static void main(String[] args) {
		System.out.println(total(1));
	}

	static int total(int day) {
		if (day == 10) {
			return 1;
		} else {
			return (total(day + 1) + 1) * 2;
		}
	}

}
