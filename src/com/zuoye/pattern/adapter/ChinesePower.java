package com.zuoye.pattern.adapter;

/**
 * �й�����
 * 
 * @author zhangxuej
 */
public class ChinesePower implements AbstractNationalPower {

	@Override
	public String provideAlternatableCurrent() {
		return "220V ������";
	}

}
