package com.zuoye.io;

import java.io.File;

public class FileDownloaderTest {



    private File source;

    private File dest;

    @org.junit.Test
    public void testCopyFileUsingStream() throws Exception {
        source = new File("e://1.avi");
        dest = new File("d://1.avi");

        long start = System.nanoTime();
        FileDownLoader.copyFileUsingStream(source, dest);
        System.out.println("Time taken by Stream Copy = " + (System.nanoTime() - start));
    }

    @org.junit.Test
    protected void testCopyFileUsingApacheCommonsIO() throws Exception {
        source = new File("e://2.avi");
        dest = new File("d://2.avi");
        long start = System.nanoTime();
        FileDownLoader.copyFileUsingApacheCommonsIO(source, dest);
        System.out.println("Time taken by Apache Commons IO Copy = " + (System.nanoTime() - start));
    }

    @org.junit.Test
    public void testCopyFileUsingJava7Files() throws Exception {
        source = new File("e://3.avi");
        dest = new File("d://3.avi");
        long start = System.nanoTime();
        FileDownLoader.copyFileUsingJava7Files(source, dest);
        System.out.println("Time taken by Java7 Files Copy = " + (System.nanoTime() - start));
    }

    @org.junit.Test
    public void testCopyFileUsingChannel() throws Exception {
        source = new File("e://4.avi");
        dest = new File("d://4.avi");
        long start = System.nanoTime();
        FileDownLoader.copyFileUsingChannel(source, dest);
        System.out.println("Time taken by Channel Copy = " + (System.nanoTime() - start));
    }

}
