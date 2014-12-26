package com.zuoye.net.chat.server;

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

	ServerGUI server;

	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public SocketInfoUpdater(ServerGUI server) {
		this.server = server;
	}

	@Override
	public void run() {
		Socket socket = server.socket;
		while (true) {
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				if (reader.ready()) {
					String info = reader.readLine();
					server.outputArea.append("Client-" + socket.getPort()
							+ " at " + f.format(new Date()) + "\n");
					server.outputArea.append("  " + info + "\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	// 设置发送按钮监听，事件相应
	@Override
	public void actionPerformed(ActionEvent e) {
		String temp = server.inputArea.getText();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		server.outputArea.append("Client " + server.socket.getLocalPort()
				+ " at " + f.format(new Date()) + "\n");
		server.outputArea.append("  " + temp + "\n");
		this.sendInfo(temp);
		server.inputArea.setText("");

	}

	private void sendInfo(String s) {
		try {
			PrintWriter pw = new PrintWriter(server.socket.getOutputStream(),
					true);
			pw.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
