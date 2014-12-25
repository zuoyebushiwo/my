package com.shidaihulian;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

public class Test extends TestCase {
	
	public List<File> getFileListByPath(String path) {
		File folder = new File(path);
		List<File> rtn = new LinkedList<File>();
		for(File temp : folder.listFiles()) {
			rtn.add(temp);
			if (temp.isDirectory()) {
				rtn.addAll(getFileListByPath(temp.getAbsolutePath()));
			} 
		}
		return rtn;
	}
	
	public void testGetFileListByPath() {
//		List<File> files = getFileListByPath("D:\\pp\\ipes_upload");
//		for(File file : files) {
//			System.out.println(file.getName());
//		}
	}
	
	public void testThread() {
		int i = 0;
		
		Thread add1 = new Thread(new AddThread(i));
		Thread add2 = new Thread(new AddThread(i));
		
		Thread sub1 = new SubThread(i);
		Thread sub2 = new SubThread(i);
		
		add1.start();
//		add2.start();
//		
//		sub1.start();
//		sub2.start();
		
		try {
			add1.join();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(i);
	}
	
	public void printGrap() {
		String a = "o";
		System.out.println(a);
		for(int i = 0; i < 4; i++) {
			a += "oo";
			System.out.println(a);
		}
	}
	
//	public void testPrintGrap() {
//		printGrap();
//	}
//	
//	public void pattern(String mail) {
//		Pattern p = Pattern.compile("\\p{Alnum}+@\\w+\\.\\p{Alpha}{2,3}");
//		Matcher m = p.matcher(mail);
//		if (m.find()) {
//			System.out.println(m.group());
//		}
//	}
//	
//	public void testPattern() {
//		pattern("junxuezhang@yeah.net");
//	}
//	
//	
	public void testJoin() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		
		BThread bt = new BThread();
		AThread at = new AThread(bt);
		
		try {
			bt.start();
			
			Thread.sleep(2000);
			
			at.start();
			at.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Exception From main ");
		}
		System.out.println(threadName + " end!");
	}
	
}

class BThread extends Thread {
	
	public BThread() {
		super("[BThread] Thread");
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(threadName + " loop at " + i);
				Thread.sleep(1000);
			}
			System.out.println(threadName + " end. ");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Exception from " + threadName + " .run ");
		}
	}
}

class AThread extends Thread {
	
	BThread bt;
	
	public AThread(BThread bt) {
		super("[AThread] Thread");
		this.bt = bt;
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		try {
			bt.join();
			System.out.println(threadName + " end. ");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Exception from " + threadName + " .run ");
		}
	}
	
}

class AddThread implements Runnable {

	int i = 0;
	
	public AddThread(int i) {
		this.i = i;
	}
	
	@Override
	public void run() { 
		add(i);
	}

	private synchronized void add(int i) {
		this.i++;
	}
	
}

class SubThread extends Thread {
	
	int i = 0;
	
	public SubThread(int i) {
		this.i = i;
	}
	
	@Override
	public void run() {
		sub(i);
	}

	private synchronized void sub(int i) {
		i--;
	}
	
}

















