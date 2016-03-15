package com.company.target.logic.search;

/**
 * 二分常找
 *
 * @date 2016年03月11日
 */
public class BinarySearch {

    private int srcs[] =

            {
                    1, 2, 3, 4, 5, 6, 7, 8, 9
            };

    private static final int key = 6;

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int index = search.search(search.srcs, 0, search.srcs.length - 1);
        System.out.println(index);
    }

    private int search(int[] Array, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key == Array[mid])
                return mid;
            else if (key < Array[mid])
                //移动low和high
                return search(Array, low, mid - 1);
            else if (key > Array[mid])
                return search(Array, mid + 1, high);
        }
        return -1;
    }

}
