package com.zuoye.thread.high.current.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��ͨ�����˻�������͸֧
 */
public class MyCount {

	private String oid; // �ʺ�
	private int cash; // �˻����
	private Lock lock = new ReentrantLock(); // �˻���
	private Condition _save = lock.newCondition(); // �������
	private Condition _draw = lock.newCondition(); // ȡ������
	
	public MyCount(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}
	
	/**
	 * ���
	 * 
	 * @param x	�������
	 * @param name ������
	 */
	public void saving(int x, String name) {
		lock.lock(); // ��ȡ��
		if (x > 0) {
			cash += x; // ���
			System.out.println(name + "���" + x + "����ǰ���Ϊ" + cash);
		}
		_draw.signalAll(); // �������еĵȴ��߳�
		lock.unlock();	// �ͷ���
	}

	/**
	 * ȡ��
	 * 
	 * @param x �������
	 * @param name ������
	 */
	public void drawing(int x, String name) {
		lock.lock();	// ��ȡ��
		try {
			if (cash - x < 0) {
				_draw.await();	// ����ȡ�����
			} else {
				cash -= x;	// ȡ��
				System.out.println(name + "ȡ��" + x + "����ǰ���" + cash);
			}
			_save.signalAll();	// �������д�����
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();	// �ͷ���
		}
	}
	
}
