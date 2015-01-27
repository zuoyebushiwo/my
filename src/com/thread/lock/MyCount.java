package com.thread.lock;

/**
 * 信用卡账户，可随意透支
 */
public class MyCount {

	/** 帐号 */
	private String oid;
	/** 账户余额 */
	private int cash;

	public MyCount(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "MyCount{" + "oid='" + oid + '\'' + ", cash=" + cash + '}';
	}

}
