package com.zhangxuej.nio.buffer;

import java.nio.FloatBuffer;

/**
 * 
 */
public class UseFloatBuffer {

	public static void main(String[] args) {
		
		// 创建FloatBuffer，容量是10，单位 float,也就是创建的buffer放的下10个float
		FloatBuffer buffer = FloatBuffer.allocate(10);
		
		for (int i = 0; i < buffer.capacity(); i++) {
			float f = (float) Math.sin((((float) i) / 10) * (2 * Math.PI));
			buffer.put(f);
		}
		
		// 反转缓冲区
		buffer.flip();
		
		while (buffer.hasRemaining()) {
			float f = buffer.get();
			System.out.println(f);
		}
		
	}
	
}
