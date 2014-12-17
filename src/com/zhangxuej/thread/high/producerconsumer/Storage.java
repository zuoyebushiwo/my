package com.zhangxuej.thread.high.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * ²Ö´¢
 * 
 * @author hadoop
 */
public class Storage {

	// ²Ö´¢×î´óÖµ
	public static int max = 10;
	
	private List<Integer> objs = new ArrayList<Integer>();
	
	public void producer(int oper) throws InterruptedException {
		Thread.sleep(10L);
		synchronized (this) {
			if (objs.size() >= max) {
				System.out.println("²Ö´¢ÒÑÂú£¬µÈ´ý");
				wait();
				System.out.println("²Ö´¢Î´Âú£¬±»»½ÐÑ");
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
