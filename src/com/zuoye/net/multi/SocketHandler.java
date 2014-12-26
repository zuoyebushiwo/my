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
			// 来自键盘的输入数据
			BufferedReader keyword = new BufferedReader(new InputStreamReader(System.in));
			
			boolean flag = true;
			
			while (flag) {
				if (reader.ready()) {
					// 捕捉来自客户端的消息	客户端没有发送消息过来时，reader.ready()为false，循环检测是否有数据，有则打印出来
					String info = reader.readLine();
					System.out.println("Client：" + socket.getPort() + " : " + info);
					
					// 如果对方输入BYE，关闭回话
					if (info.equalsIgnoreCase("BYE")) {
						socket.close();
						flag = false;
					}
				}
				
				if (keyword.ready()) {
					// 捕获来自服务器端另外一个输入流：键盘的数据。如果有数据，则发送给客户端
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
