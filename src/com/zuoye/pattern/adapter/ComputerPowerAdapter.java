package com.zuoye.pattern.adapter;

/**
 * 电脑电源适配器
 * 
 * @author zhangxuej
 */
public class ComputerPowerAdapter implements AbstractComputerPower {

	private AbstractNationalPower power = new ChinesePower();
	
	@Override
	public String provideDirectCurrent() {
		String nationalPower = power.provideAlternatableCurrent();
		return transfer(nationalPower);
	}

	private String transfer(String nationalPower) {
		System.out.println("对交流电整流，变压，输出直流电");
		return "12V 直流电";
	}

}
