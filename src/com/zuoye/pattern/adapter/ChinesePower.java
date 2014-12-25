package com.zuoye.pattern.adapter;

/**
 * 中国电网
 * 
 * @author zhangxuej
 */
public class ChinesePower implements AbstractNationalPower {

	@Override
	public String provideAlternatableCurrent() {
		return "220V 交流电";
	}

}
