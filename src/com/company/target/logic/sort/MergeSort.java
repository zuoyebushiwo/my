package com.company.target.logic.sort;

import java.util.Arrays;

/**
 * @date 2016年03月12日
 */
public class MergeSort extends Sortable.Adapter {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        System.out.println(Arrays.toString(sort.sort()));
    }

    @Override
    public int[] sort() {
        sort(srcs, 0, srcs.length - 1);
        return srcs;
    }

    /**
     * 归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     *
     * @param srcs 待排序数组
     * @return 输出有序数组
     */
    private int[] sort(int[] srcs, int low, int high) {
        int mid = (low + high) / 2;

        if (low < high) {
            // 左边
            sort(srcs, low, mid);
            // 右边
            sort(srcs, mid + 1, high);
            // 左右归并
            merge(srcs, low, mid, high);
        }
        return srcs;
    }

    private void merge(int[] srcs, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (srcs[i] < srcs[j]) {
                temp[k++] = srcs[i++];
            } else {
                temp[k++] = srcs[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = srcs[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = srcs[j++];
        }

        // 把新数组中的数覆盖srcs数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            srcs[k2 + low] = temp[k2];
        }
    }
}
