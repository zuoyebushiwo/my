package com.zuoye.logic.example.ex04;

//������4��  ��Ŀ����һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
//
//�����������n���зֽ���������Ӧ���ҵ�һ����С������k��Ȼ������������ɣ�
//
//(1)����������ǡ����n����˵���ֽ��������Ĺ����Ѿ���������ӡ�����ɡ�
//
//(2)���n <> k����n�ܱ�k��������Ӧ��ӡ��k��ֵ������n����k����,��Ϊ�µ���������,�ظ�ִ�е�һ����
//
//(3)���n���ܱ�k����������k+1��Ϊk��ֵ,�ظ�ִ�е�һ����
public class Ex04 {
	public Ex04() {
	}

	public void fengjie(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.print(i + "*");
				fengjie(n / i);
			}
		}
		System.out.print(n);
		System.exit(0);// /��������䣬�����������
	}

	public static void main(String[] args) {
		String str = "";
		Ex04 c = new Ex04();
		str = javax.swing.JOptionPane.showInputDialog("������N��ֵ������exit�˳�����");
		int N;
		N = 0;
		try {
			N = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.print(N + "�ֽ���������" + N + "=");
		c.fengjie(N);
	}
}
