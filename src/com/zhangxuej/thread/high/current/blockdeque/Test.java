package com.zhangxuej.thread.high.current.blockdeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Java线程：新特性-阻塞栈
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		BlockingDeque<Integer> bDeque = new LinkedBlockingDeque<Integer>(20);
		for (int i = 0; i < 30; i++) {
			// 将指定元素添加到此阻塞栈中，如果没有可用空间，将一直等待（如果有必要）
			bDeque.putFirst(i);
			System.out.println("向阻塞栈中添加了元素：" + i);
		}
		System.out.println("程序到此运行结束，即将推出---");
	}

}
