package com.company.target.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @date 2016年03月11日
 */
public class FileReaderTest {

    public static void main(String[] args) {
        try {
//            ioRead("E:\\WorkSpace\\my\\src\\com\\company\\target\\io\\nio\\FileReaderTest.java");
            nioRead("E:\\WorkSpace\\my\\src\\com\\company\\target\\io\\nio\\FileReaderTest.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用IO读取指定文件的前1024个字节的内容。
     *
     * @param file 指定文件名称。
     * @throws java.io.IOException IO异常。
     */
    public static void ioRead(String file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        in.read(bytes);
        System.out.println(new String(bytes));
    }

    /**
     * 使用NIO读取指定文件的前1024个字节的内容。
     * @param file 指定文件名称。
     * @throws java.io.IOException IO异常。
     */
    public static void nioRead(String file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        FileChannel channel = in.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
    }

}
