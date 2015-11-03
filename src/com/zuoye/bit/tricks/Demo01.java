package com.zuoye.bit.tricks;

import org.junit.Test;

/**
 * @author ZuoYe
 * @date 2015年11月03日
 */
public class Demo01 {

	/**
	 * 获取int型最大值
	 */
    @Test
    public void getMaxInt() {
        int max = (1 << 31) -1; //2147483647， 由于优先级关系，括号不可省略 
        assert max == Integer.MAX_VALUE;
        assert ~(1 << 31) == Integer.MAX_VALUE;
         
    }
    
    @Test
	public void getMinInt() throws Exception {
		int min = 1 << 31;//-2147483648  
		assert min == Integer.MIN_VALUE;
		assert 1 << -1 == Integer.MIN_VALUE;
	}
    
    /**
     * 获得long类型的最大值
     * 
     * @throws Exception
     */
    @Test
	public void getMaxLong() throws Exception {
		long max = ((long)1 << 127) - 1;//9223372036854775807  
		assert max == Long.MAX_VALUE;
	}
    
    /**
     * 乘以2运算
     * 
     * @throws Exception
     */
    @Test
	public void mulTwo() throws Exception {
		int n = 100;
		assert 200 == n << 1;
	}
    
    /**
     * 除以2运算
     * 
     * @throws Exception
     */
    @Test
    public void divTwo() throws Exception {
    	int n = 100;
    	assert 50 == n >> 1;
    }
    
    /**
     * 乘以2的m次方
     * 
     * @throws Exception
     */
    @Test
	public void mulTwoPower() throws Exception {
		assert 1024 == mulTwoPower(1, 10);
	}
    
    int mulTwoPower(int n,int m){//计算n*(2^m)  
    	return n << m;
    }
    
    /**
     * 除以2的m次方
     * 
     * @throws Exception
     */
    @Test
	public void divTwoPower() throws Exception {
		assert 1 == divTwoPower(1024, 10);
	}
    
    int divTwoPower(int n,int m){//计算n/(2^m)  
        return n >> m;  
    }  

}
