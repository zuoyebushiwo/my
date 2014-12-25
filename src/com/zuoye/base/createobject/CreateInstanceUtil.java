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
	 * 方式1：直接使用new的方式，不使用参数
	 */
	public static Worker createWorker() {
		return new Worker();
	}

	/**
	 * 方式1：直接使用new的方式，不使用参数
	 */
	public static Worker createWorker(String name, int age) {
		return new Worker();
	}

	/**
	 * 方式3：使用反射机制，不带参数Class对象的newInstance()方法
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
	 * 方式4：使用反射机制，Construtor的newInstance方法
	 * 
	 * @return
	 */
	public static Worker createWorker2() {
		Worker worker = null;
		try {
			Class<Worker> clazz = null;
			clazz = Worker.class;

			// 获取不带参数的构造器
			Constructor<Worker> constructor = clazz.getConstructor();
			// 使用构造器创建对象
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
	 * 方式5：使用反射机制：带参数的构造函数创建对象
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
	 * 方式6：使用序列化和反序列化创建对象，这种方式其实是根据既有的对象进行复制，这个需要实现将可序列化的对象先存到文件里
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
