package com.zuoye.pattern.proxy;

// �ͻ��˽�ɫ
public class Client {

	public static void main(String[] args) {

		// ����Station
		Station service = new Station();
		// ����������
		StationProxy proxy = new StationProxy(service);
		// ���۵���Ʊ
		proxy.sellTicket();
	}

}
