package com.zuoye.net.chat.client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientGUI extends JFrame {

	Socket socket = null;
	final JTextArea outputArea = new JTextArea(70, 70);
	final JTextArea inputArea = new JTextArea(70, 70);
	final JScrollPane outputScroll = new JScrollPane(outputArea);
	final JScrollPane inputScroll = new JScrollPane(inputArea);

	public ClientGUI() throws IOException {

		this.setTitle("Client");
		this.initClientSocket();
		SocketInfoUpdater updater = new SocketInfoUpdater(this);
		new Thread(updater).start();
		Container container = getContentPane();
		JPanel pane = new JPanel();
		container.setLayout(new BorderLayout());
		pane.setLayout(new GridLayout(2, 1, 5, 5));

		inputScroll.setAutoscrolls(true);
		outputScroll.setAutoscrolls(true);
		pane.add(outputScroll);

		pane.add(inputScroll);

		setSize(300, 300);
		container.add(pane, BorderLayout.CENTER);
		JButton send = new JButton("Send");
		send.addActionListener(updater);
		container.add(send, BorderLayout.SOUTH);

		setDefaultCloseOperation(3);

		setVisible(true);


	}

	/*
	 * 初始化socket
	 */
	private void initClientSocket() {
		// 1.创建一个Server Socket
		socket = new Socket();

		// 2.连接到指定的 server socket,指定IP 和端口号
		InetSocketAddress address = new InetSocketAddress("localhost", 18824);
		try {
			socket.connect(address);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		new ClientGUI();

	}

}