package com.zuoye.net.chat.server;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerGUI extends JFrame {

	public final Socket socket;
	// �����Ի����н���������ʾ��
	final JTextArea outputArea = new JTextArea(70, 70);
	// ��������
	final JTextArea inputArea = new JTextArea(70, 70);
	final JScrollPane outputScroll = new JScrollPane(outputArea);
	final JScrollPane inputScroll = new JScrollPane(inputArea);

	public ServerGUI(Socket socket1) throws IOException {

		// �����ض���socket
		this.socket = socket1;
		this.setTitle("Server");
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
		// Ϊ���Ͱ�ť���÷����¼�
		SocketInfoUpdater updater = new SocketInfoUpdater(this);
		send.addActionListener(updater);
		container.add(send, BorderLayout.SOUTH);
		setDefaultCloseOperation(3);
		setVisible(true);
	}
}
