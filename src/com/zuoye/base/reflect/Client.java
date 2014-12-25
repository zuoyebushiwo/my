package com.zuoye.base.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class Client {

	public static void main(String[] args) throws Exception {

		// ע�����
		annotationsOperations();

		// ���캯������
		constructorOperations();

		// �ֶβ���
		fieldOperations();

		// ��������
		methodOperations();

	}

	/**
	 * ע����أ�����
	 */
	private static void annotationsOperations() {
		Class<Human> clazz = Human.class;
		// ������ڸ�Ԫ�ص��ƶ����͵�ע�⣬�򷵻���Щע�⣬���򷵻�null��
		Author author = clazz.getAnnotation(Author.class);
		System.out.println("�����������ǣ�" + author.name());

		// ��ȡ���õ���ǰclass�ϵ����� ע��
		Annotation[] annotations = clazz.getDeclaredAnnotations();
		System.out.println("Class" + clazz.getSimpleName() + "has "
				+ annotations.length + " annotations.");
	}

	/**
	 * ����������
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	private static void constructorOperations() throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Class clazz = Human.class;

		/**
		 * Constructor<T> getConstructor(Class<?>... parameterTypes) ����һ��
		 * Constructor ��������ӳ�� Class ��������ʾ�����ָ���������췽����
		 */
		Constructor constructor = clazz.getConstructor(null); // �޲ι�����

		Constructor constructor2 = clazz.getConstructor(String.class,
				String.class, String.class); // ����String���͵Ĳ���������

		/*
		 * Constructor<?>[] getConstructors() ����һ������ĳЩ Constructor ��������飬��Щ����ӳ��
		 * Class ��������ʾ��������й������췽����
		 */
		Constructor[] cons = clazz.getConstructors();
		System.out.println("��������������Ϊ��" + cons.length);

		/*
		 * Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
		 * ����һ�� Constructor ���󣬸ö���ӳ�� Class ��������ʾ�����ӿڵ�ָ�����췽����
		 * ������Եõ�������������ڶ���Ĺ������������ǲ���public ��
		 */
		Constructor[] constructs = clazz.getDeclaredConstructors();
		System.out.println("��������������Ϊ:" + constructs.length);

		Constructor cons2 = clazz.getDeclaredConstructor(String.class,
				String.class, String.class);

		/**
		 * �������ϵ�ע��
		 */
		Annotation[] annos = cons2.getAnnotations();
		System.out.println("�˹������ϵ�ע�����Ϊ��" + annos.length);
		Function function = (Function) cons2.getAnnotation(Function.class);
		System.out.println("Function ע��:" + function.value());

		/**
		 * ��ȡ�˹������׳����쳣��Ϣ
		 */
		Class[] exceptions = cons2.getExceptionTypes();
		System.out.println("-----�������׳������쳣����:" + exceptions.length
				+ "�������£�----");
		for (Class c : exceptions) {
			System.out.println(c.getSimpleName());
		}

		/*
		 * Type[] getGenericExceptionTypes() ����һ�� Type ������Щ�����ʾ����Ҫ�ɴ�
		 * Constructor �����׳����쳣
		 */
		System.out.println("----------��������Generic Exception Types-----------");
		Type[] types = cons2.getGenericExceptionTypes();
		for (Type t : types) {
			System.out.println(t.toString());
		}

		/*
		 * Type[] getGenericParameterTypes() ��������˳�򷵻�һ�� Type ������Щ�����ʾ��
		 * Constructor ��������ʾ�ķ������β����͡�
		 */
		System.out.println("------------�����������βε�������������Ϊ��-----------");
		Type[] types2 = cons2.getGenericParameterTypes();
		for (Type t : types2) {
			System.out.println(t.toString());
		}

		/*
		 * Class<?>[] getParameterTypes() ��������˳�򷵻�һ�� Class ������Щ�����ʾ��
		 * Constructor ��������ʾ���췽�����β����͡�
		 */

		/*
		 * public int getModifiers() ��������ʽ���ش� Constructor ��������ʾ���췽���� Java
		 * �������η���Ӧ��ʹ�� Modifier �����Щ���η����н��롣
		 */
		System.out.println("--------------�����������η��ǣ�--------------");
		System.out.println(cons2.getModifiers());
		if (Modifier.isPublic(cons2.getModifiers())) {
			System.out.println("Modifier is public ");
		}

		/*
		 * String getName() ���ַ�����ʽ���ش˹��췽�������ơ�
		 */
		String constructorName = cons2.getName();
		System.out.println("-----------�˹������������ǣ�" + constructorName);

		/*
		 * Class<T> getDeclaringClass() ���� Class ���󣬸ö����ʾ�����ɴ� Constructor
		 * �����ʾ�Ĺ��췽�����ࡣ ������������������ڵ���
		 */
		Class parent = cons2.getDeclaringClass();
		System.out.println("----------�˹��������ڵ����ǣ�");
		System.out.println(parent.getCanonicalName());

		/*
		 * boolean isVarArgs() ��������˹��췽�����Դ��ɱ������Ĳ������򷵻� true�����򷵻� false��
		 */
		System.out.println("�����б��Ƿ�֧�ֿɱ������" + cons2.isVarArgs());

		/*
		 * ͨ��constructor���󴴽����� T newInstance(Object... initargs)
		 */
		Human human = (Human) cons2.newInstance(new String("louis"),
				new String("yellow"), new String("nationality"));
		System.out.println("Human's name is " + human.getName());
	}

	/**
	 * Field��ز���
	 * 
	 * @throws Exception
	 */
	private static void fieldOperations() throws Exception {
		Class clazz = Human.class;

		// �������ڶ�������г�Ա�ֶΣ�����һ�����飬����˽�г�Ա�ֶ�
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(clazz.getSimpleName() + " ����ĳ�Ա�ֶι��У�"
				+ fields.length);
		// ��ȡ���ڶ���� ָ�����Ƶĳ�Ա�ֶ� ����˽�г�Ա�ֶ�
		Field field = clazz.getDeclaredField("name");

		// ����һ������ĳЩ Field ��������飬��Щ����ӳ�� Class ��������ʾ�����ӿڵ����пɷ��ʹ����ֶΡ�
		// �����Ӹ���̳й����Ŀɷ��ʵ��ֶ�
		Field[] fields1 = clazz.getFields();
		// ����һ�� Field ��������ӳ�� Class ��������ʾ�����ӿڵ�ָ��������Ա�ֶΡ�
		// �����Ӹ���̳й����Ŀɷ��ʵ��ֶ�
		Field field2 = clazz.getField("birthDate");
		Human human = new Human("lou", "yellow", "China", "1991-10");

		/*
		 * ��ȡhuman����Ķ�Ӧ�ֶε�ֵ Object get(Object obj) XXX getXXX(Object obj) XXX
		 * Boolean,Byte,Char,Double,Long,Float,Int,Short ��
		 */
		Object value = field2.get(human);
		System.out.println("human��Ӧ�ֶ� " + field2.getName() + " ��ֵΪ��" + value);

		/*
		 * ����human����Ķ�Ӧ�ֶε�ֵ void set(Object obj, Object value) void
		 * setXXX(Object obj, XXX z) XXX
		 * Boolean,Byte,Char,Double,Long,Float,Int,Short ��
		 */
		field2.set(human, "1990-1");
		System.out.println("human �����ֵ�Ѿ����趨Ϊ��" + field2.get(human));

		/*
		 * ��ȡ��Ա�ֶε��������� Class<?> getType() Type getGenericType()
		 */
		Class type = field2.getType();
		System.out.println("�ֶ�" + field2.getName() + " ��������:" + type.getName());
	}

	/**
	 * Method ��ز���
	 * @throws Exception 
	 */
	private static void methodOperations() throws Exception {
		Class clazz = Human.class;

		// ����һ������ĳЩ Method ��������飬��Щ����ӳ�� Class
		// ��������ʾ�����ӿڣ�������Щ�ɸ����ӿ��������Լ��ӳ���ͳ��ӿڼ̳е���Щ�����ӿڣ��Ĺ��� member ������
		Method[] methods = clazz.getMethods();
		// ����һ��Method��������ӳ��Class�����ϱ�ʾ�����ӿڵ�ָ��������Ա����
		Method method = clazz.getMethod("speak", null);

		// ���� Method �����һ�����飬��Щ����ӳ�� Class
		// �����ʾ�����ӿ����������з���������������������Ĭ�ϣ��������ʺ�˽�з��������������̳еķ�����
		Method[] methods2 = clazz.getDeclaredMethods();
		// ����һ�� Method ���󣬸ö���ӳ�� Class ��������ʾ�����ӿڵ�ָ������������
		Method method2 = clazz.getDeclaredMethod("walk", null);

		/*
		 * Object invoke(Object obj, Object... args) �Դ���ָ��������ָ����������ɴ� Method
		 * �����ʾ�ĵײ㷽���� ����ĳ��������������
		 */
		Human human = new Human("lou", "yellow", "China", "1991-10");
		method2.invoke(human, null);
	}

}
