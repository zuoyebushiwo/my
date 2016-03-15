package com.company.target.beat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private String serverIp = "127.0.0.1";
	private int port = 65432;

	private Socket socket;
	private volatile boolean running = false;

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Client client = new Client();
		client.start();
	}

	public void start() throws UnknownHostException, IOException {
		// 已经运行
		if (running)
			return;

		socket = new Socket(serverIp, port);
		System.out.println("本地端口：" + socket.getLocalPort());
		socket.setKeepAlive(true);
		running = true;

		new Thread(new KeepAliveWatchDog()).start();
		new Thread(new ReceiveWatchDog()).start();

	}

	public void sendObject(Object obj) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(
				socket.getOutputStream());
		oos.writeObject(obj);
		oos.flush();
	}

	public void stop() {
		if (running)
			running = false;
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				socket = null;
			}
		}
		System.out.println("关闭客户端");
	}

	class KeepAliveWatchDog implements Runnable {
		private long checkDelay = 100;
		// 每隔10秒发送一个心跳包
		long keepAliveDelay = 10000;
		private long lastSendTime = System.currentTimeMillis();

		@Override
		public void run() {
			while (running) {
				if (System.currentTimeMillis() - lastSendTime > keepAliveDelay) {
					try {
						Client.this.sendObject(new KeepAlive());
						lastSendTime = System.currentTimeMillis();
						
					} catch (IOException e) {
						e.printStackTrace();
						Client.this.stop();
					}
					

				} else {
					try {
						Thread.sleep(checkDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
						Client.this.stop();
					}
				}
			}
		}
	}

	class ReceiveWatchDog implements Runnable {
		private long checkDelay = 100;
		// 这个时间要比心跳包发送间隔长一点，
		// 否则可能导致没有获取到服务器端的响应而结束
		long keepAliveDelay = 11000;
		private long lastReceiveTime = System.currentTimeMillis();

		@Override
		public void run() {
			while (running) {
				if (System.currentTimeMillis() - lastReceiveTime > keepAliveDelay) {
					Client.this.stop();
				} else {
					try {
						InputStream in = socket.getInputStream();
						if (in.available() > 0) {
							ObjectInputStream ois = new ObjectInputStream(in);
							Object obj = ois.readObject();
							lastReceiveTime = System.currentTimeMillis();
							
							System.out.println("接收服务器端的信息来自"+socket.getPort()+"端口："+obj);
							
						} else {
							Thread.sleep(checkDelay);
						}

					} catch (Exception e) {
						e.printStackTrace();
						Client.this.stop();
					}
				}
			}
		}
	}
}
