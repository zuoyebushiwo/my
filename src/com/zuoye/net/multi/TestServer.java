package com.zuoye.net.multi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	
	public static void main(String[] args) throws IOException {
		
		// 1.创建一个Server socket
		ServerSocket server = new ServerSocket();
		// 2.绑定监听指定端口
		InetSocketAddress address = new InetSocketAddress("localhost", 18824);
		server.bind(address);
		
		// 3.接受此端口的通讯请求
		while (true) {
			// 循环调用accept方法，返回相应的Socket
			Socket socket = server.accept();
			// 使用线程，将每一个Socket都封装到线程内，这样每个接受的socket可以自由的跟服务器通讯了
			new Thread(new SocketHandler(socket)).start();
		}
		
		
	}

}
