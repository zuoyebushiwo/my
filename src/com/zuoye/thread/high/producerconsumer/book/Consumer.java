package com.zuoye.thread.high.producerconsumer.book;

import java.nio.IntBuffer;

/**
 * ������
 * 
 * @author hadoop
 */
public class Consumer extends Thread {
	
	private int neednum;	// ���Ѳ�Ʒ������
	private Godown godown; 	// �ֿ�
	
	public Consumer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}
	
	@Override
	public void run() {
		// ����ָ�������Ĳ�Ʒ
		godown.consume(neednum);
	}
	
}
