package com.zhangxuej.thread.high.current.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Java线程：新特征-阻塞队列
 */
public class Test {

	public static void main(String[] args) {
		BlockingQueue<Integer> bqueue = new ArrayBlockingQueue<Integer>(20);
		for (int i = 0; i < 30; i++) {
			// 将指定元素添加到此队列中，如果没有可用空间，将一直等待(如果有必要)
			try {
				bqueue.put(i);
				System.out.println("向阻塞队列中添加了元素: " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("程序到此运行结束，即将推出---");
	}

}
