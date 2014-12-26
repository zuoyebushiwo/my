package com.zuoye.net.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketInfoUpdater implements Runnable, ActionListener {

	ClientGUI client;

	public SocketInfoUpdater(ClientGUI client) {
		this.client = client;
	}

	@Override
	public void run() {
		Socket socket = client.socket;

		// 循环检测输入流有没有数据传入，有则显示出来
		while (true) {

			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				if (reader.ready()) {
					String info = reader.readLine();
					SimpleDateFormat f = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");

					client.outputArea.append("Server " + socket.getPort()
							+ " at " + f.format(new Date()) + "\n");
					client.outputArea.append("  " + info + "\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 设置发送按钮监听，事件相应
	@Override
	public void actionPerformed(ActionEvent e) {
		String temp = client.inputArea.getText();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		client.outputArea.append("Client " + client.socket.getLocalPort()
				+ " at " + f.format(new Date()) + "\n");
		client.outputArea.append("  " + temp + "\n");
		this.sendInfo(temp);
		client.inputArea.setText("");

	}

	private void sendInfo(String s) {
		try {
			PrintWriter pw = new PrintWriter(client.socket.getOutputStream(),
					true);
			pw.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
