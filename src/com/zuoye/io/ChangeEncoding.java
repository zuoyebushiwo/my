package com.zuoye.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ��һ��GBK������ı��ļ�ת��Ϊһ��UTF-8������ı��ļ���

// ���ںܾ�û��IO���ˣ���ʱ�Ĵ���д���൱���ң������������£�
public class ChangeEncoding {

	public static void main(String[] args) throws Exception {
		changeEncoding("GBK", "UTF-8", "gbk.txt", "utf8.txt");
	}

	private static void changeEncoding(String inEncoding, String outEncoding,
			String inFileName, String outFileName) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(inEncoding), inEncoding));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(outFileName), outEncoding));

		String s = null;

		while ((s = reader.readLine()) != null) {
			writer.write(s, 0, s.length());
			writer.newLine();
		}

		writer.flush();
		writer.close();
		reader.close();

	}

}
