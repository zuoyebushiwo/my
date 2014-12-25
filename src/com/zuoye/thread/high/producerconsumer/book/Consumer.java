package com.zuoye.thread.high.producerconsumer.book;

import java.nio.IntBuffer;

/**
 * 消费者
 * 
 * @author hadoop
 */
public class Consumer extends Thread {
	
	private int neednum;	// 消费产品的数量
	private Godown godown; 	// 仓库
	
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
