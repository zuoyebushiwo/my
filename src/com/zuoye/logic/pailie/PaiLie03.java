package com.zuoye.logic.pailie;

import java.util.Arrays;

/**
 * 3.输出数组a的全排列(非递归) 如a={1,2,3}。输出123,132,213,231,312,321
 * 
 * 全排列的非递归算法也不唯一，我写一个最常用的按字典序非递归算法
 * 
 * 所谓字典序就是按照排列数的从大到小或从小到大输出，如123，132，2..，3...
 * 
 * 算法思想：如果能按顺序输出序列是这个算法的核心，为了保证按顺序输出先对数组a进行排序。
 * 然后从后向前找到第一个顺序对（12是顺序对，21不是）标记为i，然后再从后面向前找到第一个比i大的数，
 * 记录为j，随后交换i,j对应的值，再逆序数组a[i+1]到a[length-1]。听到这里大家一定很迷糊，
 * 我们来举个例子，比如说2431这个数我们先在i，因为31是逆序，43是逆序，24是顺序，
 * 所以i=0；接着我们找j，第一个比2大的数是3，所以j=3，然后交换i，j变成（3，4，2，1）
 * 我们看看为什么要交换2,3？因为这个算法的核心思想是按字典序，而2431是以2开头的最大排列，
 * 下一个数就得是以3开头了（如果原数是2341按算法就是先要变成2431），
 * 接着3421这个数要进行i+1到length-1之间的逆序，变成3124，这个是2431的下一个数。
 * 所以可以看出交换后的数从下位开始到最后一定是一个逆序排列，所以逆序后才变成了相对的“最小值”。
 *
 */
public class PaiLie03 {

	public void runNoRecursionOfPermutation(int[] a) {

		Arrays.sort(a);// 对数组排序
		while (true) {

			printArray(a);// 输出一个排列

			int i;// 从后向前，记录一对顺序值中的小值下标
			int j;// 从后向前，记录比i大的第一个数

			for (i = a.length - 2; i >= 0; i--) {

				if (a[i] < a[i + 1])// 如果找到i跳出
					break;
				else if (i == 0)// 说明是最大逆序数退出函数
					return;
			}
			for (j = a.length - 1; j > i; j--) {
				if (a[j] > a[i])// 找到j跳出
					break;
			}
			swap(a, i, j);// 交换i，j
			reverse(a, i + 1, a.length - 1);// 翻转
		}
	}

	public void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void reverse(int[] a, int i, int j) {
		while (i < j)
			swap(a, i++, j--);
	}

	public void printArray(int[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		PaiLie03 robot = new PaiLie03();
		int[] a = { 1, 2, 3 };
		robot.runNoRecursionOfPermutation(a);

	}

}
