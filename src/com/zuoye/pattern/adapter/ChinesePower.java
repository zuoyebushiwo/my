package com.zuoye.pattern.adapter;

/**
 * �й�����
 * 
 */
public class ChinesePower implements AbstractNationalPower {

	@Override
	public String provideAlternatableCurrent() {
		return "220V ������";
	}

}
