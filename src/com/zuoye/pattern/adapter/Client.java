package com.zuoye.pattern.adapter;

public class Client {

	public static void main(String[] args) {
		
		AbstractComputerPower computerPower = new ComputerPowerAdapter();
		System.out.println(computerPower.provideDirectCurrent());
		
	}
	
}
