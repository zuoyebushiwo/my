package com.zuoye.logic.pailie;

import java.util.Arrays;

/**
 * 2.输出数组a的全排列(可重复取) 如a={1,2}。输出11,12,21,22
 * 
 * 如果知道a的length，可以用暴力法求解(n的循环)
 * 
 * 如果不知道a的length的情况下：
 * 
 * 算法思想：用一个辅助空间b数组存储待输出的排列，用一个参数index记录一个排列的个数
 *
 */
public class PaiLie02 {
	public void runPermutation(int[] a) {

		if (null == a || a.length == 0)
			return;
		int[] b = new int[a.length];// 辅助空间，保存待输出排列数
		getAllPermutation(a, b, 0);
	}

	public void getAllPermutation(int[] a, int[] b, int index) {
		if (index == a.length) {
			for (int i = 0; i < index; i++) {
//				System.out.print(b[i] + " ");
			}
//			System.out.println();
			return;
		}

		for (int i = 0; i < a.length; i++) {
			b[index] = a[i];
			System.out.println(Arrays.toString(b));
			getAllPermutation(a, b, index + 1);
		}
	}

	public static void main(String[] args) {
		PaiLie02 robot = new PaiLie02();
		int[] a = { 1, 2, 3 };
		robot.runPermutation(a);
	}
}