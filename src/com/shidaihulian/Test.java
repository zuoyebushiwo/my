package com.shidaihulian;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

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
		List<File> files = getFileListByPath("D:\\pp\\ipes_upload");
		for(File file : files) {
			System.out.println(file.getName());
		}
	}

}
