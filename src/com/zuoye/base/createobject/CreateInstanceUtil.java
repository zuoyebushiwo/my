package com.zuoye.base.createobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.naming.spi.ObjectFactory;

/**
 * 
 */
public class CreateInstanceUtil {

	/**
	 * ��ʽ1��ֱ��ʹ��new�ķ�ʽ����ʹ�ò���
	 */
	public static Worker createWorker() {
		return new Worker();
	}

	/**
	 * ��ʽ1��ֱ��ʹ��new�ķ�ʽ����ʹ�ò���
	 */
	public static Worker createWorker(String name, int age) {
		return new Worker();
	}

	/**
	 * ��ʽ3��ʹ�÷�����ƣ���������Class�����newInstance()����
	 * 
	 * @return
	 */
	public static Worker createWorker1() {
		Class<Worker> clazz = Worker.class;
		try {
			Worker worker = clazz.newInstance();
			return worker;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ʽ4��ʹ�÷�����ƣ�Construtor��newInstance����
	 * 
	 * @return
	 */
	public static Worker createWorker2() {
		Worker worker = null;
		try {
			Class<Worker> clazz = null;
			clazz = Worker.class;

			// ��ȡ���������Ĺ�����
			Constructor<Worker> constructor = clazz.getConstructor();
			// ʹ�ù�������������
			worker = constructor.newInstance();

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return worker;
	}

	/**
	 * ��ʽ5��ʹ�÷�����ƣ��������Ĺ��캯����������
	 * 
	 * @param name
	 * @param age
	 * @return
	 */
	public static Worker createWorker3(String name, Integer age) {
		Class<Worker> clazz = Worker.class;
		try {
			Constructor<Worker> constructor = clazz.getConstructor(
					name.getClass(), age.getClass());
			Worker worker = constructor.newInstance(name, age);
			return worker;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ʽ6��ʹ�����л��ͷ����л������������ַ�ʽ��ʵ�Ǹ��ݼ��еĶ�����и��ƣ������Ҫʵ�ֽ������л��Ķ����ȴ浽�ļ���
	 * 
	 * @param objectPath
	 * @return
	 */
	public static Worker createWorker4(String objectPath) {
		ObjectInput input = null;
		Worker worker = null;
		try {
			input = new ObjectInputStream(new FileInputStream(objectPath));
			worker = (Worker) input.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return worker;
	}
	
	public static void storeObject2File(String objectPath) {
		Worker worker = new Worker();
		try {
			ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream(objectPath));
			out.writeObject(worker);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
