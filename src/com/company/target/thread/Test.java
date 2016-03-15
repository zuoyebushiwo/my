package com.company.target.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date 2016年03月12日
 */
public class Test {

    public static void main(String[] args) {
        // 创建等待队列
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(20);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2, TimeUnit.MILLISECONDS, queue);

        Lock lock = new ReentrantLock();
    }

}
