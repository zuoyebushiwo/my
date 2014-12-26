package com.zuoye.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocket {
	
	public static void main(String[] args) throws IOException {
		
		// 1.����һ��Socket
		Socket socket = new Socket();
		// 2.���ӵ�ָ��server socket��ָ��IP�Ͷ˿�
		InetSocketAddress address = new InetSocketAddress("localhost", 18824);
		socket.connect(address);
		
		// 3.���ӳɹ��󣬻�ȡ��Ӧ��������������������ݽ���
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		
		BufferedReader keyword = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			// ��׽���Է������˷�������Ϣ�������û�з���Ϣ����ʱ��br.ready()Ϊfalse��ѭ������Ƿ������ݣ������ӡ����
			if (br.ready()) {
				String info = br.readLine();
				System.out.println("Server: " + info);
			}
			
			// �������Է�����������һ�������������̵����ݡ���������ݣ����͸���������
			if (keyword.ready()) {
				String test = keyword.readLine();
				pw.println(test);
				System.out.println("Client: " + test);
			}
		}
	}

}
