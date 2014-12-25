package com.zhangxuej.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 */
public class FastCopyFile {

	public static void main(String[] args) throws Exception {

		String path = System.getProperty("user.dir");

		args = new String[] {
				path + "/src/com/zhangxuej/nio/FastCopyFile.java",
				path
						+ "/src/com/zhangxuej/nio/nio_read_write/CopyFileTest.java" };

		if (args.length < 2) {
			System.err.println("Usage: java FastCopyFile infile outfile");
			System.exit(1);
		}

		String infile = args[0];
		String outfile = args[1];

		FileInputStream fis = new FileInputStream(infile);
		FileOutputStream fos = new FileOutputStream(outfile);

		FileChannel fcin = fis.getChannel();
		FileChannel fcout = fos.getChannel();

		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

		while (true) {
			buffer.clear();
			int r = fcin.read(buffer);

			if (r == -1) {
				break;
			}

			buffer.flip();

			fcout.write(buffer);
		}

	}

}
