package com.zhangxuej.thread.high.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * 仓储
 * 
 * @author hadoop
 */
public class Storage {

	// 仓储最大值
	public static int max_size = 100;
	public int curnum;

	public Storage(int curnum) {
		this.curnum = curnum;
	}

	/**
	 * 生产指定数量的产品
	 * 
	 * @param neednum
	 * @throws InterruptedException
	 */
	public synchronized void producer(int neednum) throws InterruptedException {
		// 测试是否需要生产
		while (curnum + neednum >= max_size) {
			System.out.println("要生产的产品数量" + neednum + "超过剩余库存量"
					+ (max_size - curnum) + ", 暂时不能执行生产任务！");
			wait();
		}

		// 满足生产条件，则进行生产，这里简单的更改当前库存量
		curnum += neednum;
		System.out.println("已经生产了" + neednum + "个产品，现仓储量为" + curnum);

		// 唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}

	/**
	 * 消费指定数量的产品
	 * 
	 * @param neednum
	 * @throws InterruptedException
	 */
	public synchronized void consumer(int neednum) throws InterruptedException {
		// 测试是否可消费
		while (neednum > curnum) {
			System.out.println("当前需消费的数量" + neednum + "大于剩余库存量" + curnum + "等待之。");
			wait();
		}
		
		// 满足消费条件，则进行消费，这里简单的更改当前库存量
		curnum -= neednum;
		System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + curnum);
		
		// 唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}

}
