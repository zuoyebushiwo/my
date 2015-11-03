package com.zuoye.bit.tricks;

import static org.junit.Assert.*;

import org.junit.Test;

public class Demo02 {

	/**
	 * 判断一个数的奇偶性
	 * 
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		assert !isOddNumber(1024);
		assert isOddNumber(1025);
	}

	boolean isOddNumber(int n) {
		return (n & 1) == 1;
	}

	/**
	 * 不用临时变量交换两个数
	 * 
	 * @throws Exception
	 */
	@Test
	public void swap() throws Exception {
		int a = 1, b = 2;

		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));

		a ^= b;
		b ^= a;
		a ^= b;
	}

	/**
	 * 取绝对值（某些机器上，效率比n>0 ? n:-n 高）
	 * 
	 * @throws Exception
	 */
	@Test
	public void abs() throws Exception {
		assert 10 == abs(-10);
	}

	int abs(int n) {
		return (n ^ (n >> 31)) - (n >> 31);
		/* n>>31 取得n的符号，若n为正数，n>>31等于0，若n为负数，n>>31等于-1 
		若n为正数 n^0=0,数不变，若n为负数有n^-1 需要计算n和-1的补码，然后进行异或运算， 
		结果n变号并且为n的绝对值减1，再减去-1就是绝对值 */  
	}
	
	/**
	 * 取两个数的最大值（某些机器上，效率比a>b ? a:b高）
	 * 
	 * @throws Exception
	 */
	@Test
	public void max() throws Exception {
		assert 100 == max(99, 100);
	}
	
	int max(int a,int b){  
	    return b & ((a-b) >> 31) | a & (~(a-b) >> 31);  
	    /*如果a>=b,(a-b)>>31为0，否则为-1*/  
	}  
	
	int min(int a,int b){  
	    return a & ((a-b) >> 31) | b & (~(a-b) >> 31);  
	    /*如果a>=b,(a-b)>>31为0，否则为-1*/  
	}  
	
	/**
	 * 13.判断符号是否相同
	 * 
	 * @throws Exception
	 */
	@Test
	public void isSameSign() throws Exception {
		
	}
	
	boolean isSameSign(int x, int y){ //有0的情况例外  
	    return (x ^ y) >= 0; // true 表示 x和y有相同的符号， false表示x，y有相反的符号。  
	}  
	
	/**
	 * 计算2的n次方
	 * 
	 * @param n
	 * @return
	 */
	int getFactorialofTwo(int n){//n > 0  
	    return 2 << (n-1);//2的n次方  
	} 
	
	@Test
	public void isFactorialofTwo() throws Exception {
		System.out.println(isFactorialofTwo(102));
	}
	
	/**
	 * 判断一个数是不是2的幂
	 * 
	 * @param n
	 * @return
	 */
	boolean isFactorialofTwo(int n){  
	    return n > 0 ? (n & (n - 1)) == 0 : false;  
	    /*如果是2的幂，n一定是100... n-1就是1111.... 
	       所以做与运算结果为0*/  
	}  
	
	
	/**
	 * 对2的n次方取余
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	int quyu(int m,int n){//n为2的次方  
	    return m & (n - 1);  
	    /*如果是2的幂，n一定是100... n-1就是1111.... 
	     所以做与运算结果保留m在n范围的非0的位*/  
	}  
	
	/**
	 * 求两个整数的平均值
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int getAverage(int x, int y){  
        return (x + y) >> 1;   
	}
	
	@Test
	public void getBit() throws Exception {
		int n = 1124;
		int m = 7;
		
		System.out.println(Integer.toBinaryString(n));
		System.out.println("从低位到高位,取n的第m位：" + getBit(n, m));
	}
	
	/**
	 * 从低位到高位,取n的第m位
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	int getBit(int n, int m) {
		return (n >> (m-1)) & 1;  
	}
	
	@Test
	public void setBitToOne() throws Exception {
		int n = 1024;
		int m = 7;
		System.out.println(Integer.toBinaryString(n));
		int x = setBitToOne(n, m);
		System.out.println(Integer.toBinaryString(x));
	}
	
	/**
	 * 从低位到高位.将n的第m位置1
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	int setBitToOne(int n, int m){  
	    return n | (1 << (m-1));  
	    /*将1左移m-1位找到第m位，得到000...1...000 
	      n在和这个数做或运算*/  
	}  
	
	
	/**
	 * 从低位到高位,将n的第m位置0
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	int setBitToZero(int n, int m){  
	    return n & ~(1 << (m-1));  
	    /* 将1左移m-1位找到第m位，取反后变成111...0...1111 
	       n再和这个数做与运算*/  
	}  
}
