package com.zhangxuej.thread.high.current.lock.reemtractreadwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

	public static void main(String[] args) {
		// 创建被并发访问的账户
		MyCount myCount = new MyCount("zhangxuej", 10000);
		// 创建一个锁对象
		ReadWriteLock myLock = new ReentrantReadWriteLock();
		// 创建一个线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		// 创建一些并发访问用户，一个信用卡，存的存，取的取，查询的查询，好热闹啊
		User u1 = new User("张三", myCount, 10000, myLock, false);
		User u2 = new User("张三他爸", myCount, 0, myLock, true);
		User u3 = new User("张三他妈", myCount, 5000, myLock, false);
		User u4 = new User("张三他妹", myCount, -4000, myLock, false);
		User u5 = new User("张三媳妇", myCount, -3000, myLock, false);

		// 在线程池中执行各个用户的操作
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		pool.execute(u5);

		// 关闭线程池
		pool.shutdown();
	}

}

class User implements Runnable {

	private String name; // 用户名
	private MyCount myCount; // 所需要操作的用户
	private int iocash; // 操作的金额，当然有正负之分
	private ReadWriteLock myLock; // 执行操作所需要的锁对象
	private boolean ischeck; // 是否查询

	public User(String name, MyCount myCount, int iocash, ReadWriteLock myLock,
			boolean ischeck) {
		this.name = name;
		this.myCount = myCount;
		this.iocash = iocash;
		this.myLock = myLock;
		this.ischeck = ischeck;
	}

	@Override
	public void run() {
		// 是否查询
		if (ischeck) {
			myLock.readLock().lock();
			System.out.println(name + "查询账户余额，为：" + myCount.getCash());
			myLock.readLock().unlock();
		} else {
			myLock.writeLock().lock();
			System.out.println(name + "操作账户金额为：" + iocash + "账户目前余额为：" + myCount.getCash());
			myCount.setCash(iocash + myCount.getCash());
			System.out.println(name + "操作账户金额为：" + iocash + "成功，账户目前余额为：" + myCount.getCash());
			myLock.writeLock().unlock();
		}
	}

}

/**
 * 封装用户对银行账户的操作
 */
class MyCount {

	private String oid; // 帐号
	private int cash; // 账户余额

	public MyCount(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "MyCount{" + "oid='" + oid + '\'' + ", cash=" + cash + '}';
	}
}