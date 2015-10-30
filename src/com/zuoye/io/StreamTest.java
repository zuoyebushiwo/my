package com.zuoye.io;

import java.net.URL;

/**
 * @author ZuoYe
 * @date 2015年10月30日
 */
public class StreamTest {

    public static void main(String[] args) {
        URL url = StreamTest.class.getResource("StreamTest.class");
        System.out.println(url.getPath());
    }

}
