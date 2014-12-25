package com.zuoye.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	public static void main(String[] args) throws IOException {
		// 1.����һ��Server Socket
		ServerSocket server = new ServerSocket();
		// 2.�󶨼���ָ���˿�
		InetSocketAddress address = new InetSocketAddress("localhost", 18824);
		server.bind(address);
		// 3.���ܴ˶˿ڵ�ͨѶ����
		Socket socket = server.accept();
		// ��û�пͻ��˶��������Ӧǰ������Ĵ��벻��ִ�У���һֱ����
		
		// �������˵��������������
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		
		// ���Լ��̵���������
		BufferedReader keyword = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			if (reader.ready()) {
				// ��׽���Կͻ��˷�������Ϣ	�ͻ���û�з�����Ϣʱ��reader.ready()Ϊfalse��ѭ������Ƿ������ݣ������ӡ����
				String info = reader.readLine();
				System.out.println("Client: " + info);
			}
			
			if (keyword.ready()) {
				// �������Է�����������һ�������������̵����ݡ���������ݣ����͸��ͻ���
				String test = keyword.readLine();
				writer.print(test);
				System.out.println("Server:" + test);
			}
		}
	}
	
}
