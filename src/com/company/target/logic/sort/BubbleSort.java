package com.company.target.logic.sort;

import java.util.Arrays;

/**
 * 冒泡排序:
 * （1）基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，
 * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 *
 * @date 2016年03月10日
 */
public class BubbleSort extends Sortable.Adapter {

    public static void main(String[] args) {
        Sortable sort = new BubbleSort();
        System.out.println(Arrays.toString(sort.sort()));
    }

    @Override
    public int[] sort() {

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < srcs.length; i++) {
                if (i + 1 < srcs.length && srcs[i] > srcs[i + 1]) {
                    int temp = srcs[i + 1];
                    srcs[i + 1] = srcs[i];
                    srcs[i] = temp;
                    flag = true;
                }
            }
        }
        return srcs;
    }
}
