package com.company.target.io.nio;

import java.nio.FloatBuffer;

/**
 * @date 2016年03月11日
 */
public class UseFloatBuffer {

    public static void main(String[] args) {

        // 分配一个容量为10的新的 float 缓冲区
        FloatBuffer buffer = FloatBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i);
        }

        // 反转此缓冲区
        buffer.flip();

        // 告知在当前位置和限制之间是否有元素
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

    }

}
