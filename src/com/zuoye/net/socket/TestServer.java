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
		// 1.创建一个Server Socket
		ServerSocket server = new ServerSocket();
		// 2.绑定监听指定端口
		InetSocketAddress address = new InetSocketAddress("localhost", 18824);
		server.bind(address);
		// 3.接受此端口的通讯请求
		Socket socket = server.accept();
		// 在没有客户端对其进行响应前，下面的代码不会执行，将一直阻塞
		
		// 服务器端的输出流和输入流
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		
		// 来自键盘的输入数据
		BufferedReader keyword = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			if (reader.ready()) {
				// 捕捉来自客户端发来的消息	客户端没有发来消息时，reader.ready()为false，循环检测是否有数据，有则打印出来
				String info = reader.readLine();
				System.out.println("Client: " + info);
			}
			
			if (keyword.ready()) {
				// 捕获来自服务器端另外一个输入流：键盘的数据。如果有数据，则发送给客户端
				String test = keyword.readLine();
				writer.print(test);
				System.out.println("Server:" + test);
			}
		}
	}
	
}
