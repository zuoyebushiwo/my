package com.zuoye.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class Test {
	
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
		buffer.put(0, (byte) 'M').put((byte) 'w');
		
		buffer.position(2).mark().position(4);
		
		buffer.flip();
		
//		byte[] myByteArray = new byte[buffer.limit()];
//		for (int i = 0; buffer.hasRemaining(); i++) {
//			myByteArray[i] = buffer.get();
//		}
//		
		buffer.compact();
		
//		CharBuffer charBuffer = CharBuffer.wrap("Hello World");
//		CharBuffer charBuffer = CharBuffer.allocate(8);
//		charBuffer.position(3).limit(6).mark().position(5);
//		
//		CharBuffer dupeBuffer = charBuffer.duplicate();
//		charBuffer.clear();
		
		// ·Ö¸î
//		CharBuffer charBuffer = CharBuffer.allocate (8); 
//		charBuffer.position (3).limit (5); 
//		CharBuffer sliceBuffer = charBuffer.slice( );
//		
//		char[] myBuffer = new char[100];
//		CharBuffer cb = CharBuffer.wrap(myBuffer);
//		cb.position(12).limit(21);
//		CharBuffer sliced = cb.slice();
//		
//		ByteOrder byteOrder;
//		
//		System.out.println(ByteOrder.nativeOrder().toString());
		
		ByteBuffer byteBuffer = 
				ByteBuffer.allocate (7).order (ByteOrder.BIG_ENDIAN); 
				CharBuffer charBuffer = byteBuffer.asCharBuffer( );
		
	}

}
