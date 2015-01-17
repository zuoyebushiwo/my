package com.zuoye.logic.sort;

import java.util.Random;

/**
 * 排序算法
 */
public class SortAlgorithm {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] sort = new int[10];
		for (int i = 0; i < sort.length; i++) {
			sort[i] = ran.nextInt(50);
		}
		System.out.println("排序前的数组为：");
		for (int i : sort) {
			System.out.println(i + " ");
		}

		directInsertSort(sort);
		System.out.println();
		System.out.println("排序后的数组为：");
		for (int i : sort) {
			System.out.println(i + " ");
		}
	}

	/**
	 * 依次比较相邻的两个数，将小数放在前面，大数放在后面 冒泡排序，具有稳定性 时间复杂度为O（n^2） 不及堆排序，快速排序O（nlogn，底数为2）
	 * 
	 * @author liangge
	 * 
	 */
	private static void buddleSort(int[] sort) {
		for (int i = 1; i < sort.length; i++) {
			for (int j = 0; j < sort.length - i; j++) {
				if (sort[j] > sort[j + 1]) {
					int temp = sort[j + 1];
					sort[j + 1] = sort[j];
					sort[j] = temp;
				}
			}
		}
	}

	/**
	 * 插入排序
	 * 
	 * @param sort
	 */
	private static void directInsertSort(int[] sort) {
		for (int i = 1; i < sort.length; i++) {
			int index = i - 1;
			int temp = sort[i];
			while (index >= 0 && sort[index] > temp) {
				sort[index + 1] = sort[index];
				index--;
			}
			sort[index + 1] = temp;

		}
	}

	/**
	 * 选择排序 每一趟从待排序的数据元素中选出最小（或最大）的一个元素， 顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
	 * 选择排序是不稳定的排序方法。
	 * 
	 * @author liangge
	 * 
	 */
	private static void selectSort(int[] sort) {

		for (int i = 0; i < sort.length - 1; i++) {
			for (int j = i + 1; j < sort.length; j++) {
				if (sort[j] < sort[i]) {
					int temp = sort[j];
					sort[j] = sort[i];
					sort[i] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序 通过一趟排序将要排序的数据分割成独立的两部分， 其中一部分的所有数据都比另外一部分的所有数据都要小，
	 * 然后再按此方法对这两部分数据分别进行快速排序， 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
	 * 
	 * @author liangge
	 * 
	 */
	private static void quickSort(int[] sort, int start, int end) {
		// 设置关键数据key为要排序数组的第一个元素
		// 即第一趟排序后，key右边的数全部比key大，key左边的数全部比key小
		int key = sort[start];
		// 设置数组左边的索引，往右移动判断比key大的数
		int i = start;
		// 设置数组右边的索引，往左移动判断比key小的数
		int j = end;

		// 如果左边索引比右边索引小，则还有数据没有排序
		while (i < j) {
			while (sort[j] > key && j > start) {
				j--;
			}
			while (sort[i] < key && i < end) {
				i++;
			}

			if (i < j) {
				int temp = sort[i];
				sort[i] = sort[j];
				sort[j] = temp;
			}
		}

		// 如果左边索引比右边索引要大，说明第一次排序完成，将sort[j]与key对换，
		// 即保持了key左边的数比key小，key右边的数比key大
		if (i > j) {
			int temp = sort[j];
			sort[j] = sort[start];
			sort[start] = temp;
		}
		// 递归调用
		if (j > start && j < end) {
			quickSort(sort, start, j - 1);
			quickSort(sort, j + 1, end);
		}

	}
}
