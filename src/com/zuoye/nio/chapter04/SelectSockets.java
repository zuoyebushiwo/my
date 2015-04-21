package com.zuoye.nio.chapter04;

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
	}

}
