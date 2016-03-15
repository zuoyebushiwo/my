package com.company.target.logic.sort;

/**
 * @date 2016年03月10日
 */
public interface Sortable {

    int[] sort();

    public abstract class Adapter implements Sortable {

        protected int srcs[] =

                {
                        49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23,

                        34, 15, 35, 25, 53, 51
                };
    }

}
