package com.zhangxuej.thread.high.current.lock.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java�̣߳���
 * 
 * @author hadoop
 */
public class LockTest {

	public static void main(String[] args) {
		// �����������ʵ��˻�
		MyCount myCount = new MyCount("zhangxuej", 10000);
		// ����һ��������
		Lock lock = new ReentrantLock();
		// ����һ���̳߳�
		ExecutorService pool = Executors.newCachedThreadPool();
		// ����һЩ���������û���һ�����ÿ�����Ĵ棬ȡ��ȡ�������ְ�
		User u1 = new User("����", myCount, -4000, lock);
		User u2 = new User("��������", myCount, 6000, lock);
		User u3 = new User("��������", myCount, -8000, lock);
		User u4 = new User("����", myCount, 800, lock);
		
		// ���̳߳���ִ�и����û��Ĳ���
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		
		// �ر��̳߳�
		pool.shutdown();
	}

}

/**
 * ���ÿ��û�
 */
class User implements Runnable {

	private String name; // �û���
	private MyCount myCount; // ��Ҫ�������˻�
	private int iocash; // �����Ľ���Ȼ������֮��
	private Lock myLock; // ִ�в�������Ҫ��������

	public User(String name, MyCount myCount, int iocash, Lock myLock) {
		this.name = name;
		this.myCount = myCount;
		this.iocash = iocash;
		this.myLock = myLock;
	}

	@Override
	public void run() {
		// ��ȡ��
		myLock.lock();
		// ִ���ֽ�ҵ��
		System.out.println(name + "���ڲ���" + myCount + "�˻������Ϊ" + iocash
				+ "����ǰ���Ϊ" + myCount.getCash());
		myCount.setCash(myCount.getCash() + iocash);
		System.out.println(name + "����" + myCount + "�˻��ɹ������Ϊ" + iocash
				+ "����ǰ���Ϊ" + myCount.getCash());
		// �ͷ������������߳�û�л���ִ����
		myLock.unlock();
	}

}

/**
 * ���ÿ��˻���������͸֧
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
