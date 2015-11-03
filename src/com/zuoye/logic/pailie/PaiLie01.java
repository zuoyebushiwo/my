package com.zuoye.logic.pailie;

/**
 * 1.输出数组a的全排列(不可重复取) 如a={1,2,3}。输出123，132，213，231，312，321
 * 
 * 这个是最基本，也是最经典的排列
 * 
 * 算法思想：可以输出1加上23的全排列，2加13的全排列，3加上12的全排列，运用递归求比如23的全排列..
 * 依次递归下去；比如现在要2开头求全排，首先要交换1，2的位置，让a[0]变为2，在用递归求13的所有全排列，
 * 前面加个2就是2开头的所有全排列了，最后运用回溯再把1，2调换回来。
 */
public class PaiLie01 {
	public void runPermutation(int[] a) {
		getAllPermutation(a, 0);
	}

	/* index用于控制如上述分析中2加上13的所有全列的 */
	public void getAllPermutation(int[] a, int index) {

		/* 与a的元素个数相同则输出 */
		if (index == a.length - 1) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = index; i < a.length; i++) {
			swap(a, index, i);
			getAllPermutation(a, index + 1);
			swap(a, index, i);
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		PaiLie01 robot = new PaiLie01();
		int[] a = { 1, 2, 3, 4 };
		robot.runPermutation(a);

	}
}
