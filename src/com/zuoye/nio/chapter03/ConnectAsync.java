package com.zuoye.nio.chapter03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Demonstrate asynchronous connection of a SocketChannel.
 * 
 * @author Ron Hitchens (ron@ronsoft.com)
 */
public class ConnectAsync {

	public static void main(String[] args) throws Exception {
		String host = "127.0.0.1";
		int port = 80;

		InetSocketAddress addr = new InetSocketAddress(host, port);
		SocketChannel sc = SocketChannel.open();
		sc.configureBlocking(false);
		System.out.println("initiating connection");
		sc.connect(addr);
		while (!sc.finishConnect()) {
			doSomethingUseful();
		}
		System.out.println("connection established");
		// Do something with the connected socket
		// The SocketChannel is still nonblocking
		sc.close();
	}

	private static void doSomethingUseful() {
		System.out.println("doing something useless");
	}
}
