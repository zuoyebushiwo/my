package com.zuoye.logic.sort;

import java.util.Random;

/**
 * �����㷨
 */
public class SortAlgorithm {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] sort = new int[10];
		for (int i = 0; i < sort.length; i++) {
			sort[i] = ran.nextInt(50);
		}
		System.out.println("����ǰ������Ϊ��");
		for (int i : sort) {
			System.out.println(i + " ");
		}

		directInsertSort(sort);
		System.out.println();
		System.out.println("����������Ϊ��");
		for (int i : sort) {
			System.out.println(i + " ");
		}
	}

	/**
	 * ���αȽ����ڵ�����������С������ǰ�棬�������ں��� ð�����򣬾����ȶ��� ʱ�临�Ӷ�ΪO��n^2�� ���������򣬿�������O��nlogn������Ϊ2��
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
	 * ��������
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
	 * ѡ������ ÿһ�˴Ӵ����������Ԫ����ѡ����С������󣩵�һ��Ԫ�أ� ˳��������ź�������е����ֱ��ȫ�������������Ԫ�����ꡣ
	 * ѡ�������ǲ��ȶ������򷽷���
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
	 * �������� ͨ��һ������Ҫ��������ݷָ�ɶ����������֣� ����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��
	 * Ȼ���ٰ��˷����������������ݷֱ���п������� ����������̿��Եݹ���У��Դ˴ﵽ�������ݱ���������С�
	 * 
	 * @author liangge
	 * 
	 */
	private static void quickSort(int[] sort, int start, int end) {
		// ���ùؼ�����keyΪҪ��������ĵ�һ��Ԫ��
		// ����һ�������key�ұߵ���ȫ����key��key��ߵ���ȫ����keyС
		int key = sort[start];
		// ����������ߵ������������ƶ��жϱ�key�����
		int i = start;
		// ���������ұߵ������������ƶ��жϱ�keyС����
		int j = end;

		// �������������ұ�����С����������û������
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

		// �������������ұ�����Ҫ��˵����һ��������ɣ���sort[j]��key�Ի���
		// ��������key��ߵ�����keyС��key�ұߵ�����key��
		if (i > j) {
			int temp = sort[j];
			sort[j] = sort[start];
			sort[start] = temp;
		}
		// �ݹ����
		if (j > start && j < end) {
			quickSort(sort, start, j - 1);
			quickSort(sort, j + 1, end);
		}

	}
}
