package com.zuoye.bit.tricks;

import org.junit.Test;

/**
 * @author ZuoYe
 * @date 2015年11月03日
 */
public class Demo01 {

    @Test
    public void getMaxInt() {
        int max = (1 << 31) -1;
        assert max == Integer.MAX_VALUE;
    }

}
