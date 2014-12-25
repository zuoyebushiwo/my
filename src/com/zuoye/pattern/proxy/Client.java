package com.zuoye.pattern.proxy;

// 客户端角色
public class Client {

	public static void main(String[] args) {

		// 创建Station
		Station service = new Station();
		// 创建代理类
		StationProxy proxy = new StationProxy(service);
		// 代售点售票
		proxy.sellTicket();
	}

}
