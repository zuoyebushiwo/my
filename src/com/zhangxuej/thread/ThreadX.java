package com.zhangxuej.thread;

/**
 * �߳�֮���ͨ��
 * 
 * @author hadoop
 */
public class ThreadX {
	
	public static void main(String[] args) {
		ThreadY y = new ThreadY();
		y.start();
		
		synchronized (y) {
			try {
				System.out.println("�ȴ�����b��ɼ���....");
				// ��ǰ�߳�A�ȴ�
				y.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Y���������ܺ��ǣ�" + y.total);
		}
	}

}

class ThreadY extends Thread {
	
	int total;
	
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 101; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				total += i;
			}
			
			// (��ɼ�����) �����ڴ˶���������ϵȴ��ĵ����̣߳��ڱ������߳�X������
			notify();
		}
		
	}
	
}