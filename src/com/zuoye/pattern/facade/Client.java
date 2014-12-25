package com.zuoye.pattern.facade;

public class Client {

	public void applyRunCompany() {

		GreenChannel.applyRunCompany();
	}

	public static void main(String[] args) {
		new Client().applyRunCompany();
	}

}
