package com.zuoye.net.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * server的主线程，监听socket端口，为每一个Socket	创建一个对话框 
 */
public class MainThread extends Thread {

	public List<Socket> sockets = new ArrayList<Socket>();
	
	@Override
	public void run() {
		// 1.创建一个Server Socket
		ServerSocket server = null;
		try {
			server = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("localhost", 18824);
			server.bind(address);
			
			while (true) {
				// 循环调用accept方法，返回相应的Socket
				Socket socket = server.accept();
				sockets.add(socket);
				
				// 为每一个请求的Socket提供	界面"回话"
                ServerGUI serverGUI = new ServerGUI(socket);  
				// 创建监听socket数据流输入信息，有数据输入，则更新到GUI
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
