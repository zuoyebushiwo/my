package com.thread.hight;

/**
 * ������
 */
public class Producer extends Thread { 
	
	private int neednum; // ������Ʒ������
	private Godown godown; // �ֿ�
	
	public Producer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}
	
	@Override
	public void run() {
		// ����ָ�������Ĳ�Ʒ
		godown.produce(neednum);
	}
}