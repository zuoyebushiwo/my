package com.zuoye.thread.high;

public class User {
	
	private String code;
	private int cash;
	
	public User(String code, int cash) {
		this.code = code;
		this.cash = cash;
	}
	
	/**
	 * ҵ�񷽷�
	 * 
	 * @param x ���x��Ԫ
	 */
	public void oper(int x) {
		try {
			Thread.sleep(10L);
			synchronized (this) {
				this.cash += x;
				System.out.println(Thread.currentThread().getName() + "���н���������" + x + ", ��ǰ�˻����Ϊ��" + cash);
			}
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "User{" + "code='" + code + '\'' + ", cash=" + cash + '}';
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
