package com.company.target.logic.sort;

import java.util.Arrays;

/**
 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * <p/>
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 *
 * @date 2016年03月10日
 */
public class SelectSort extends Sortable.Adapter {

    public static void main(String[] args) {
        Sortable sort = new SelectSort();
        System.out.println(Arrays.toString(sort.sort()));
    }

    @Override
    public int[] sort() {
        int position = 0;
        for (int i = 0; i < srcs.length; i++) {
            int tmp = srcs[i];
            int j = i + 1;
            position = i;

            while (j < srcs.length) {
                if (srcs[j] < tmp) {
                    tmp = srcs[j];
                    position = j;
                }
                j++;
            }
            srcs[position] = srcs[i];
            srcs[i] = tmp;
        }
        return srcs;
    }
}
