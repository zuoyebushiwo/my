package com.thread;

/**
 * Java�̣߳��̵߳ĵ���-�ϲ� 
 */
public class Test {
	
	public static void main(String[] args) {
		
		Thread t1 = new MyThread();
		t1.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("���̵߳�" + i + "�����У�");
			if (i > 2) {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
