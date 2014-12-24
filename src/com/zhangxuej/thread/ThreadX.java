package com.zhangxuej.thread;

/**
 * 线程之间的通信
 * 
 * @author hadoop
 */
public class ThreadX {
	
	public static void main(String[] args) {
		ThreadY y = new ThreadY();
		y.start();
		
		synchronized (y) {
			try {
				System.out.println("等待对象b完成计算....");
				// 当前线程A等待
				y.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Y对象计算的总和是：" + y.total);
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
			
			// (完成计算了) 唤醒在此对象监视器上等待的单个线程，在本例中线程X被唤醒
			notify();
		}
		
	}
	
}