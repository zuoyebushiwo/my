package com.zuoye.thread;

public class Calculator extends Thread {
	
	int total;
	
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 101; i++) {
				total += i;
			}
			
			// ֪ͨ�����ڴ˶����ϵȴ����߳�
			notifyAll();
		}
	}

}
