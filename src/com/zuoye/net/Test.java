package com.zuoye.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	
	public static void main(String[] args) throws IOException {
		System.out.println(InetAddress.getByName("::1"));
		
		System.out.println(InetAddress.getLocalHost());
		System.out.println(InetAddress.getLoopbackAddress());
	}

}
