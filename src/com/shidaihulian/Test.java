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
	
	int i = 0;
	
	class AddThread implements Runnable {

		
		@Override
		public void run() {
			add();
		}

		private synchronized void add() {
			++i;
		}
		
	}
	
	class SubThread extends Thread {
		
		
		@Override
		public void run() {
			sub();
		}

		private void sub() {
			i--;
		}
		
	}

	
	public void testThread() {
		Thread add1 = new Thread(new AddThread());
		Thread add2 = new Thread(new AddThread());
		
		Thread sub1 = new SubThread();
		Thread sub2 = new SubThread();
		
		add1.start();
		add2.start();
		
		sub1.start();
		sub2.start();
		
		try {
//			add1.join();
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
	
	public void testPrintGrap() {
		printGrap();
	}
	
	public void pattern(String mail) {
		Pattern p = Pattern.compile("\\p{Alnum}+@\\w+\\.\\p{Alpha}{2,3}");
		Matcher m = p.matcher(mail);
		if (m.find()) {
			System.out.println(m.group());
		}
	}
	
	public void testPattern() {
		pattern("junxuezhang@yeah.net");
	}
	
}
