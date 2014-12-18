package com.zhangxuej.thread.high.current.lock.reemtractreadwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

	public static void main(String[] args) {
		// �������������ʵ��˻�
		MyCount myCount = new MyCount("zhangxuej", 10000);
		// ����һ��������
		ReadWriteLock myLock = new ReentrantReadWriteLock();
		// ����һ���̳߳�
		ExecutorService pool = Executors.newCachedThreadPool();
		// ����һЩ���������û���һ�����ÿ�����Ĵ棬ȡ��ȡ����ѯ�Ĳ�ѯ�������ְ�
		User u1 = new User("����", myCount, 10000, myLock, false);
		User u2 = new User("��������", myCount, 0, myLock, true);
		User u3 = new User("��������", myCount, 5000, myLock, false);
		User u4 = new User("��������", myCount, -4000, myLock, false);
		User u5 = new User("����ϱ��", myCount, -3000, myLock, false);

		// ���̳߳���ִ�и����û��Ĳ���
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		pool.execute(u5);

		// �ر��̳߳�
		pool.shutdown();
	}

}

class User implements Runnable {

	private String name; // �û���
	private MyCount myCount; // ����Ҫ�������û�
	private int iocash; // �����Ľ���Ȼ������֮��
	private ReadWriteLock myLock; // ִ�в�������Ҫ��������
	private boolean ischeck; // �Ƿ��ѯ

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
		// �Ƿ��ѯ
		if (ischeck) {
			myLock.readLock().lock();
			System.out.println(name + "��ѯ�˻���Ϊ��" + myCount.getCash());
			myLock.readLock().unlock();
		} else {
			myLock.writeLock().lock();
			System.out.println(name + "�����˻����Ϊ��" + iocash + "�˻�Ŀǰ���Ϊ��" + myCount.getCash());
			myCount.setCash(iocash + myCount.getCash());
			System.out.println(name + "�����˻����Ϊ��" + iocash + "�ɹ����˻�Ŀǰ���Ϊ��" + myCount.getCash());
			myLock.writeLock().unlock();
		}
	}

}

/**
 * ��װ�û��������˻��Ĳ���
 */
class MyCount {

	private String oid; // �ʺ�
	private int cash; // �˻����

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