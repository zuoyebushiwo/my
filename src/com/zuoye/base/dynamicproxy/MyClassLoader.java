package com.zuoye.base.dynamicproxy;

/*
 * �Զ���һ��������������ڽ��ֽ���ת��Ϊclass���� 
 */
public class MyClassLoader extends ClassLoader {

	public Class<?> defineMyClass(byte[] b, int off, int len) {
		return super.defineClass(b, off, len);
	}
	
}
