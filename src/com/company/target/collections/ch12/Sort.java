package com.company.target.collections.ch12;

/**
 * 排序
 */
public class Sort {

	/**
	 * 插入排序
	 * 
	 * @param x
	 * @param off 开始的索引值
	 * @param len 将被排序的数量
	 */
	public static void insertionSort(int[] x, int off, int len) {
		for (int i = off; i < off + len; i++) {
			for (int j = i; j > off && x[j-1] > x[j]; j--) {
				swap(x, j, j-1);
			}
		}
	}

	/**
	 * @param x
	 * @param a
	 * @param b
	 */
	private static void swap(int[] x, int a, int b) {
		int t = x[a];
		x[a] = x[b];
		x[b] = t;
	}
	
}
