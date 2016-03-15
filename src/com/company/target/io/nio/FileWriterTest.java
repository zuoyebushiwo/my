package com.company.target.io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @date 2016年03月11日
 */
public class FileWriterTest {

    public static void main(String[] args) throws IOException {
        // 首先从 FileOutputStream 获取一个通道：
        FileOutputStream out = new FileOutputStream("writesomebytes.txt");
        FileChannel channel = out.getChannel();
        // 下一步是创建一个缓冲区并在其中放入一些数据，这里，用message来表示一个持有数据的数组。
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String a = "你好";
        for (int i = 0; i < a.getBytes().length; ++i) {
            buffer.put(a.getBytes()[i]);
        }
        buffer.flip();
        // 最后一步是写入缓冲区中：
        channel.write(buffer);

    }

}
