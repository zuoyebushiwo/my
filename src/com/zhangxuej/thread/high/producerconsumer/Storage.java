package com.zhangxuej.thread.high.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * �ִ�
 * 
 * @author hadoop
 */
public class Storage {

	// �ִ����ֵ
	public static int max_size = 100;
	public int curnum;

	public Storage(int curnum) {
		this.curnum = curnum;
	}

	/**
	 * ����ָ�������Ĳ�Ʒ
	 * 
	 * @param neednum
	 * @throws InterruptedException
	 */
	public synchronized void producer(int neednum) throws InterruptedException {
		// �����Ƿ���Ҫ����
		while (curnum + neednum >= max_size) {
			System.out.println("Ҫ�����Ĳ�Ʒ����" + neednum + "����ʣ������"
					+ (max_size - curnum) + ", ��ʱ����ִ����������");
			wait();
		}

		// �����������������������������򵥵ĸ��ĵ�ǰ�����
		curnum += neednum;
		System.out.println("�Ѿ�������" + neednum + "����Ʒ���ֲִ���Ϊ" + curnum);

		// �����ڴ˶���������ϵȴ��������߳�
		notifyAll();
	}

	/**
	 * ����ָ�������Ĳ�Ʒ
	 * 
	 * @param neednum
	 * @throws InterruptedException
	 */
	public synchronized void consumer(int neednum) throws InterruptedException {
		// �����Ƿ������
		while (neednum > curnum) {
			System.out.println("��ǰ�����ѵ�����" + neednum + "����ʣ������" + curnum + "�ȴ�֮��");
			wait();
		}
		
		// ����������������������ѣ�����򵥵ĸ��ĵ�ǰ�����
		curnum -= neednum;
		System.out.println("�Ѿ�������" + neednum + "����Ʒ���ֲִ���Ϊ" + curnum);
		
		// �����ڴ˶���������ϵȴ��������߳�
		notifyAll();
	}

}
