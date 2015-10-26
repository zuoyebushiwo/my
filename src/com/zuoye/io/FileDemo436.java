package com.zuoye.io;

import java.io.*;

/**
 * 将两个txt文件合并为一个txt文件
 *
 * @author ZuoYe
 * @date 2015年10月26日
 */
public class FileDemo436 {

    public static void main(String[] args) throws IOException {
        File file1 = new File("d:" + File.separator + "hello1.txt");
        File file2 = new File("d:" + File.separator + "hello2.txt");
        File file3 = new File("d:" + File.separator + "hello3.txt");

        InputStream input1 = new FileInputStream(file1);
        InputStream input2 = new FileInputStream(file2);
        OutputStream output = new FileOutputStream(file3);
        SequenceInputStream se = new SequenceInputStream(input1, input2);
        int temp = 0;
        while ((temp = se.read()) != -1) {
            output.write(temp);
        }

        input1.close();
        input2.close();
        output.close();
        se.close();
    }

}
