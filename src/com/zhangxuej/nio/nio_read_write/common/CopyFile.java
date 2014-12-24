package com.zhangxuej.nio.nio_read_write.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {

	public static void main(String[] args) throws Exception {

		String path = System.getProperty("user.dir");

		args = new String[] {
				path + "/src/com/zhangxuej/nio/nio_read_write/common/CopyFile.java",
				path
						+ "/src/com/zhangxuej/nio/nio_read_write/CopyFileTest.java" };

		FileInputStream fis = new FileInputStream(args[0]);
		FileOutputStream fout = new FileOutputStream(args[1]);
		
		byte[] b = new byte[(int) new File(args[0]).length()];
		
		int p = fis.read(b);
		
		
		while (p != -1) {
			p = fis.read(b);
		}
		
		System.out.println(b.length);
		
		fout.write(b);
		fout.flush();
	}
}
