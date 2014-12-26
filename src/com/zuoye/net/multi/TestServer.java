package com.zuoye.net.multi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	
	public static void main(String[] args) throws IOException {
		
		// 1.����һ��Server socket
		ServerSocket server = new ServerSocket();
		// 2.�󶨼���ָ���˿�
		InetSocketAddress address = new InetSocketAddress("localhost", 18824);
		server.bind(address);
		
		// 3.���ܴ˶˿ڵ�ͨѶ����
		while (true) {
			// ѭ������accept������������Ӧ��Socket
			Socket socket = server.accept();
			// ʹ���̣߳���ÿһ��Socket����װ���߳��ڣ�����ÿ�����ܵ�socket�������ɵĸ�������ͨѶ��
			new Thread(new SocketHandler(socket)).start();
		}
		
		
	}

}
