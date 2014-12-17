package com.zhangxuej.thread.high.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * �ִ�
 * 
 * @author hadoop
 */
public class Storage {

	// �ִ����ֵ
	public static int max = 10;
	
	private List<Integer> objs = new ArrayList<Integer>();
	
	public void producer(int oper) throws InterruptedException {
		Thread.sleep(10L);
		synchronized (this) {
			if (objs.size() >= max) {
				System.out.println("�ִ��������ȴ�");
				wait();
				System.out.println("�ִ�δ����������");
			} else {
				objs.add(oper);
			}
		}
		Thread.sleep(10L);
	}
	
	public void consumer() throws InterruptedException {
		Thread.sleep(10L);
		synchronized (this) {
			if (objs.size() > 0) {
				objs.remove(0);
			}
			notifyAll();
		}
		Thread.sleep(10L);
	}
	
}
