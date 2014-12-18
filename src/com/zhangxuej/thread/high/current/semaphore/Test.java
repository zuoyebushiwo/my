package com.zhangxuej.thread.high.current.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Java�̣߳�������-�ź���
 * 
 * @author hadoop
 */
public class Test {

	public static void main(String[] args) {
		MyPool myPool = new MyPool(20);
		// �����̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		MyThread t1 = new MyThread("����A", myPool, 21);
		MyThread t2 = new MyThread("����B", myPool, 12);
		MyThread t3 = new MyThread("����C", myPool, 7);
		
		// ���̳߳���ִ������
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		
		// �ر��̳߳�
		pool.shutdown();
	}

}

/**
 * һ����
 */
class MyPool {

	private Semaphore sp; // ����ص��ź���

	/**
	 * �صĴ�С�������С�ᴫ�ݸ��ź���
	 * 
	 * @param size
	 */
	public MyPool(int size) {
		this.sp = new Semaphore(size);
	}

	public Semaphore getSp() {
		return sp;
	}

	public void setSp(Semaphore sp) {
		this.sp = sp;
	}

}

class MyThread extends Thread {

	private String threadname; // �̵߳�����
	private MyPool myPool; // �Զ����̳߳�
	private int x; // �����ź����Ĵ�С

	public MyThread(String threadname, MyPool myPool, int x) {
		this.threadname = threadname;
		this.myPool = myPool;
		this.x = x;
	}

	@Override
	public void run() {
		try {
			// �Ӵ��ź�����ȡ������Ŀ�����
			myPool.getSp().acquire(x);
			// TODO Ҳ����������������ӵ�ҵ��
			System.out.println(threadname + "�ɹ���ȡ��" + x + "����ɣ�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// �ͷŸ�����Ŀ����ɣ����䷵�ص��ź���
			myPool.getSp().release(x);
			System.out.println(threadname + "�ͷ���" + x + "����ɣ�");
		}
	}

}