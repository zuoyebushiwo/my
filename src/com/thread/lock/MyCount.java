package com.thread.lock;

/**
 * ���ÿ��˻���������͸֧
 */
public class MyCount {

	/** �ʺ� */
	private String oid;
	/** �˻���� */
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