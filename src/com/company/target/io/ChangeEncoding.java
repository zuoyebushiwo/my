package com.company.target.io;

import java.io.*;

/**
 * @date 2016年03月09日
 */
public class ChangeEncoding {

    public void changeEncoding(String inEncoding, String outEncoding,
                               String inFile, String outFile) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), inEncoding));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), outEncoding));

            String s = null;
            while ((s = reader.readLine()) != null) {
                writer.write(s, 0, s.length());
                writer.newLine();
            }

            writer.flush();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChangeEncoding encoding = new ChangeEncoding();
        encoding.changeEncoding("gbk", "utf-8", "E:/WorkSpace/my/src/com/company/target/Target.java", "E:/WorkSpace/my/src/com/company/target/Target01.txt");
    }

}
