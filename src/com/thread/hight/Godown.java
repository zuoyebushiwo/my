package com.thread.hight;

/**
 * �ֿ�
 */
public class Godown {

	public static final int max_size = 100; // �������
	public int curnum; // ��ǰ�����

	public Godown() {

	}

	public Godown(int curnum) {
		this.curnum = curnum;
	}

	/**
	 * ����ָ�������Ĳ�Ʒ
	 * 
	 * @param neednum
	 */
	public synchronized void produce(int neednum) {
		// �����Ƿ���Ҫ����
		while (neednum + curnum > max_size) {
			System.out.println("Ҫ�����Ĳ�Ʒ����" + neednum + "����ʣ������"
					+ (max_size - curnum) + "����ʱ����ִ����������!");
			try {
				// ��ǰ�������̵߳ȴ�
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
	 */
	public synchronized void consume(int neednum) {
		// �����Ƿ������
		while (curnum < neednum) {
			try {
				// ��ǰ�������̵߳ȴ�
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// ����������������������ѣ�����򵥵ĸ��ĵ�ǰ�����
		curnum -= neednum;
		System.out.println("�Ѿ�������" + neednum + "����Ʒ���ֲִ���Ϊ" + curnum);
		
		// �����ڴ˶���������ϵȴ��������߳�
		notifyAll();
	}

}
