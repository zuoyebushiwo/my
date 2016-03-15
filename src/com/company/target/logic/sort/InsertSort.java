package com.company.target.logic.sort;

import java.util.Arrays;

/**
 * 插入排序:
 * <p/>
 * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
 * <p/>
 * 好顺序的，现在要把第n 个数插到前面的有序数中，使得这 n个数
 * <p/>
 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
 *
 * @date 2016年03月10日
 */
public class InsertSort extends Sortable.Adapter {

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        System.out.println(Arrays.toString(sort.sort()));
    }


    @Override
    public int[] sort() {
        int temp = 0;
        for (int i = 1; i < srcs.length; i++) {
            int j = i - 1;
            temp = srcs[i];
            while (j >= 0 && srcs[j] > temp) {
                srcs[j + 1] = srcs[j];
                j--;
            }
            srcs[j + 1] = temp;
        }
        return srcs;
    }
}
