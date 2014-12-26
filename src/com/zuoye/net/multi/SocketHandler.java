package com.zuoye.net.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler implements Runnable {
	
	private Socket socket;
	
	public SocketHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			// ���Լ��̵���������
			BufferedReader keyword = new BufferedReader(new InputStreamReader(System.in));
			
			boolean flag = true;
			
			while (flag) {
				if (reader.ready()) {
					// ��׽���Կͻ��˵���Ϣ	�ͻ���û�з�����Ϣ����ʱ��reader.ready()Ϊfalse��ѭ������Ƿ������ݣ������ӡ����
					String info = reader.readLine();
					System.out.println("Client��" + socket.getPort() + " : " + info);
					
					// ����Է�����BYE���رջػ�
					if (info.equalsIgnoreCase("BYE")) {
						socket.close();
						flag = false;
					}
				}
				
				if (keyword.ready()) {
					// �������Է�����������һ�������������̵����ݡ���������ݣ����͸��ͻ���
					String test = keyword.readLine();
					writer.println(test);
					System.out.println("Server: " + test);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
