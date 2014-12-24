package com.zhangxuej.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class UseFileLocks {

	private static final int start = 10;
	private static final int end = 20;

	public static void main(String[] args) throws Exception {

		// Get file channel
		RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
		FileChannel fc = raf.getChannel();

		// Get lock
		System.out.println("Tring to get lock!");
		FileLock lock = fc.lock(start, end, false);
		System.out.println("Got lock!");

		// Pause
		System.out.println("pause");
		Thread.sleep(3000);

		// Release lock
		System.out.println("going to release lock");
		lock.release();
		System.out.println("released lock");

		raf.close();

	}

}
