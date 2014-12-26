package com.zuoye.net.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * server�����̣߳�����socket�˿ڣ�Ϊÿһ��Socket	����һ���Ի��� 
 */
public class MainThread extends Thread {

	public List<Socket> sockets = new ArrayList<Socket>();
	
	@Override
	public void run() {
		// 1.����һ��Server Socket
		ServerSocket server = null;
		try {
			server = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("localhost", 18824);
			server.bind(address);
			
			while (true) {
				// ѭ������accept������������Ӧ��Socket
				Socket socket = server.accept();
				sockets.add(socket);
				
				// Ϊÿһ�������Socket�ṩ	����"�ػ�"
                ServerGUI serverGUI = new ServerGUI(socket);  
				// ��������socket������������Ϣ�����������룬����µ�GUI
                new Thread(new SocketInfoUpdater(serverGUI)).start();  
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MainThread().start();
	}
	
}
