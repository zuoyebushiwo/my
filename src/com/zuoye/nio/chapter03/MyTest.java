package com.zuoye.nio.chapter03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.InterruptibleChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.AbstractSelectableChannel;

public class MyTest {

	Channel channel;

	InterruptibleChannel interruptibleChannel;

	WritableByteChannel writableByteChannel;

	ReadableByteChannel readableByteChannel;

	AbstractSelectableChannel abstractSelectableChannel;

	AbstractInterruptibleChannel abstractInterruptibleChannel;

	FileChannel fileChannel;

	SocketChannel sokeChannel;

	ServerSocketChannel serverSocketChannel;

	DatagramChannel datagramChannel;

	public static void main(String[] args) throws IOException {

//		SocketChannel sc = SocketChannel.open();
//		sc.connect(new InetSocketAddress("somehost", 80));
//		
//		ServerSocketChannel ssc = ServerSocketChannel.open();
//		ssc.socket().bind(new InetSocketAddress(81));
//		
//		DatagramChannel dc = DatagramChannel.open();
//		
//		RandomAccessFile raf = new RandomAccessFile("somefile", "r");
//		
//		FileChannel fc = raf.getChannel();
//		
//		FileInputStream input = new FileInputStream("filename");
//		FileChannel channel = input.getChannel();
//		
//		channel.write(ByteBuffer.wrap("something".getBytes()));
		
		
		FileChannel fileChannel = null;
		
		ByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,
				100, 200);
		
		byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
		
		MappedByteBuffer mappedByteBuffer;
		
		SelectableChannel selectableChannel;
		
		AbstractSelectableChannel abstractSelectableChannel;
		
		ServerSocketChannel serverSocketChannel;
		
		DatagramChannel datagramChannel;
		
		SocketChannel socketChannel;
	}

}
