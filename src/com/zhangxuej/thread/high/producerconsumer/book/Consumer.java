package com.zhangxuej.thread.high.producerconsumer.book;

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
