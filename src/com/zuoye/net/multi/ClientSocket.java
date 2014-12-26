package com.zuoye.net.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocket {

	public static void main(String[] args) throws IOException {
		
		// 1.����һ������Server��socket
		Socket socket = new Socket();
		
		// 2.���ӵ�ָ����server socket��ָ��IP�Ͷ˿ں�
		InetSocketAddress address = new InetSocketAddress("localhost", 18824);
		socket.connect(address);
		
		// 3.���ӳɹ��󣬻�ȡ��Ӧ��������������������ݽ���
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader keyword = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			// ��׽���Է������˷�������Ϣ		��������û�з�����Ϣ����ʱ��br.ready()Ϊfalse��ѭ������Ƿ������ݣ������ӡ����
			if (br.ready()) {
				String info = br.readLine();
				System.out.println("Server��" + info);
			}
			
			// �������Է�����������һ�������������̵����ݡ���������ݣ����͸���������
			if (keyword.ready()) {
				String test = keyword.readLine();
				if ("BYE".equals(test)) {
					br.close();
					pw.close();
					socket.close();
				}
				pw.println(test);
				System.out.println("Client: " + test);
			}
		}
		
	}
	
}
