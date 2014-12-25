package com.zhangxuej.thread.high.producerconsumer.book;

/**
 * 生产者
 * 
 * @author hadoop
 */
public class Producer extends Thread {

	private int neednum;	// 生产产品的数量
	private Godown godown; 	// 仓库
	
	public Producer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}
	
	@Override
	public void run() {
		// 生产指定数量的产品
		godown.produce(neednum);
	}
}
