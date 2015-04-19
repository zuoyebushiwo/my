package com.zuoye.nio.chapter03;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Test Copying between channels
 * 
 * @author hadoop
 */
public class ChannelCopy {

	public static void main(String[] args) throws IOException {
		ReadableByteChannel source = Channels.newChannel(System.in);
		WritableByteChannel dest = Channels.newChannel(System.out);

		channelCopy1(source, dest);
		source.close();
		dest.close();
		
	}

	private static void channelCopy1(ReadableByteChannel src,
			WritableByteChannel dest) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);

		while (src.read(buffer) != -1) {
			buffer.flip();

			dest.write(buffer);

			buffer.compact();
		}

		// EOF will leave buffer in fill state
		buffer.flip();
		// Make sure that the buffer is fully drained
		while (buffer.hasRemaining()) {
			dest.write(buffer);
		}
	}

	/**
	 * Channel copy method 2. This method performs the same copy, but assures
	 * the temp buffer is empty before reading more data. This never requires
	 * data copying but may result in more systems calls. No post-loop cleanup
	 * is needed because the buffer will be empty when the loop is exited.
	 */
	private static void channelCopy2(ReadableByteChannel src,
			WritableByteChannel dest) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		while (src.read(buffer) != -1) {
			// Prepare the buffer to be drained
			buffer.flip();
			// Make sure that the buffer was fully drained
			while (buffer.hasRemaining()) {
				dest.write(buffer);
			}
			// Make the buffer empty, ready for filling
			buffer.clear();
		}
	}

}
