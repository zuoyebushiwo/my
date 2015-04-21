package com.zuoye.nio.chapter04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Simple echo-back server which listens for incoming stream connections and
 * echoes back whatever it reads. A single Selector object is used to listen to
 * the server socket (to accept new connections) and all the active socket
 * channels.
 * 
 * @author Ron Hitchens (ron@ronsoft.com)
 */
public class SelectSockets {

	public static int PORT_NUMBER = 1234;

	public static void main(String[] argv) throws Exception {
		new SelectSockets().go(argv);
	}

	private void go(String[] argv) {
		int port = PORT_NUMBER;
		if (argv.length > 0) { // Override default listen port
			port = Integer.parseInt(argv[0]);
		}
		System.out.println("Listening on port " + port);

		try {
			// Allocate an unbound server socket channel
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			// Get the associated ServerSocket to bind it with
			ServerSocket serverSocket = serverChannel.socket();

			// Create a new Selector for use below
			Selector selector = Selector.open();
			// Set the port the server channel will listen to
			serverSocket.bind(new InetSocketAddress(port));
			// Set nonblocking mode for the listening socket
			serverChannel.configureBlocking(false);
			// Register the ServerSocketChannel with the Selector
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				// This may block for a long time. Upon returning, the
				// selected set contains keys of the ready channels.
				int n = selector.select();

				if (n == 0) {
					continue; // nothing to do
				}

				// Get an iterator over the set of selected keys
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();

				// Look at each key in the selected set
				while (it.hasNext()) {
					SelectionKey key = it.next();

					// Is a new connection coming in?
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key
								.channel();
						SocketChannel channel = server.accept();
						registerChannel(selector, channel, SelectionKey.OP_READ);
						sayHello(channel);
					}

					// Is there data to read on this channel?
					if (key.isReadable()) {
						readDataFromSocket(key);
					}

					// Remove Key from selected set; it's been handled
					it.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sayHello(SocketChannel channel) {

	}

	private void readDataFromSocket(SelectionKey key) {

	}

	/**
	 * Register the given channel with the given selector for the given
	 * operations of interest
	 */
	private void registerChannel(Selector selector, SocketChannel channel,
			int ops) {
		if (channel == null) {
			return; // could happen
		}

		try {
			// Set the new channel nonblocking
			channel.configureBlocking(false);

			// Register it with the selector
			channel.register(selector, ops);
		} catch (ClosedChannelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
