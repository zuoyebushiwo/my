package com.zhangxuej.thread.high;

public class User {
	
	private String code;
	private int cash;
	
	public User(String code, int cash) {
		this.code = code;
		this.cash = cash;
	}
	
	/**
	 * 业务方法
	 * 
	 * @param x 添加x万元
	 */
	public void oper(int x) {
		try {
			Thread.sleep(10L);
			synchronized (this) {
				this.cash += x;
				System.out.println(Thread.currentThread().getName() + "运行结束，增加" + x + ", 当前账户余额为：" + cash);
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
