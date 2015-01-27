package com.thread.hight;

/**
 * 消费者
 */
public class Consumer extends Thread {
	
	private int neednum; // 消费产品的数量
	private Godown godown; // 仓库
	
	public Consumer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}
	
	@Override
	public void run() {
		// 消费指定数量的产品
		godown.consume(neednum);
	}

}
