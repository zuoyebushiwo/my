package com.zuoye.pattern.proxy;

// ��Ʊ����ӿ�ʵ���࣬��վ
public class Station implements TicketService {

	@Override
	public void sellTicket() {
		System.out.println("\n\t��Ʊ.....\n");

	}

	@Override
	public void inquire() {
		System.out.println("\n\t��ѯ��������\n");
	}

	@Override
	public void withdraw() {
		System.out.println("\n\t��Ʊ......\n");
	}
}
