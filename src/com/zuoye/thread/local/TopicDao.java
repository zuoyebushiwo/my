package com.zuoye.thread.local;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TopicDao {

	private Connection conn;// ��һ�����̰߳�ȫ�ı���

	public void addTopic() {
		try {
			// �����÷��̰߳�ȫ����
			Statement stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
