package com.zhangxuej.thread.high.current.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Java�̣߳�������-��������
 */
public class Test {

	public static void main(String[] args) {
		BlockingQueue<Integer> bqueue = new ArrayBlockingQueue<Integer>(20);
		for (int i = 0; i < 30; i++) {
			// ��ָ��Ԫ����ӵ��˶����У����û�п��ÿռ䣬��һֱ�ȴ�(����б�Ҫ)
			try {
				bqueue.put(i);
				System.out.println("�����������������Ԫ��: " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("���򵽴����н����������Ƴ�---");
	}

}
