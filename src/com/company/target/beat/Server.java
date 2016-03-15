package com.company.target.beat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port = 65432;

	private volatile boolean running = false;

	private ServerSocket serverSocket;

	public static void main(String[] args) {
		new Server().start();
	}

	public void start() {
		if (running)
			return;

		running = true;
		try {
			serverSocket = new ServerSocket(port, 5);
			while (running) {
				Socket socket = serverSocket.accept();
				System.out.println("收到来自" + socket.getPort() + "端口的连接");
				new Thread(new DefaultSocket(socket)).start();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			Server.this.stop();
		}

	}

	public void stop() {
		if (running)
			running = false;
		if (serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("关闭服务器端");
	}

	class DefaultSocket implements Runnable {
		private Socket socket;
		boolean flag = true;
		long lastReceiveTime;
		// 如果10秒内没收到客户端的信息，就自动端口连接
		// 但是这里检测用的是11秒
		private long receiveTimeDelay = 11000;
		private long checkDelay = 100;

		public DefaultSocket(Socket socket) {
			this.socket = socket;
			lastReceiveTime = System.currentTimeMillis();
		}

		@Override
		public void run() {
			while (running && flag) {
				if (System.currentTimeMillis() - lastReceiveTime > receiveTimeDelay) {
					shutdownSocket();
				} else {
					try {
						InputStream in = socket.getInputStream();
						if (in.available() > 0) {
							// 接收心跳包
							ObjectInputStream ois = new ObjectInputStream(in);
							Object obj = ois.readObject();
							lastReceiveTime = System.currentTimeMillis();

							System.out.println("接收客户端的信息来自" + socket.getPort()+ "端口：" + obj);
							// TODO 处理逻辑

							// 响应心跳包
							ObjectOutputStream oos = new ObjectOutputStream(
									socket.getOutputStream());
							oos.writeObject(new KeepAlive());
							oos.flush();

						} else {
							Thread.sleep(checkDelay);
						}
					} catch (Exception e) {
						e.printStackTrace();
						shutdownSocket();
					}
				}
			}
		}

		public void shutdownSocket() {
			System.out.println("服务器端主动关闭");

			if (flag)
				flag = false;

			if (socket != null) {
				System.out.println("端口：" + socket.getPort());

				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
