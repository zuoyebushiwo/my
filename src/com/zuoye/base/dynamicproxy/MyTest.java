package com.zuoye.base.dynamicproxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest {

	public static void main(String[] args) throws Exception {
		// ��ȡ���ص�class�ļ��ڵ��ֽ��룬ת�����ֽ�������
		File file = new File(".");
		InputStream input = new FileInputStream(file.getCanonicalPath()
				+ "/bin/com/zuoye/base/dynamicproxy/Programmer.class");

		byte[] result = new byte[1024];

		int count = input.read(result);
		// ʹ���Զ����������� byte�ֽ�������ת��Ϊ��Ӧ��class����
		MyClassLoader loader = new MyClassLoader();
		Class clazz = loader.defineMyClass(result, 0, count);
		// ���Լ����Ƿ�ɹ�����ӡclass���������
		System.out.println(clazz.getCanonicalName());

		// ʵ����һ��Programmer����
		Object o = clazz.newInstance();
		// ����Programmer��code����
		clazz.getMethod("code", null).invoke(o, null);

	}
}
