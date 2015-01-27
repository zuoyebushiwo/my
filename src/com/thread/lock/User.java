package com.thread.lock;

import java.util.concurrent.locks.Lock;

/**
 * ���ÿ��û�
 */
public class User implements Runnable {

	/** �û��� */
	private String name;
	/** ��Ҫ�������˻� */
	private MyCount myCount;
	/** �����Ľ���Ȼ������֮���� */
	private int iocash;
	/** ִ�в�������������� */
	private Lock myLock;

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
