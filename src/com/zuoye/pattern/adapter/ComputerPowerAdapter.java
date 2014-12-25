package com.zuoye.pattern.adapter;

/**
 * ���Ե�Դ������
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
		System.out.println("�Խ�������������ѹ�����ֱ����");
		return "12V ֱ����";
	}

}
