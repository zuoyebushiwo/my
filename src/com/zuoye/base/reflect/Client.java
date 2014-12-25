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

		// 注解操作
		annotationsOperations();

		// 构造函数操作
		constructorOperations();

		// 字段操作
		fieldOperations();

		// 方法操作
		methodOperations();

	}

	/**
	 * 注解相关，操作
	 */
	private static void annotationsOperations() {
		Class<Human> clazz = Human.class;
		// 如果存在该元素的制定类型的注解，则返回这些注解，否则返回null。
		Author author = clazz.getAnnotation(Author.class);
		System.out.println("这个类的作者是：" + author.name());

		// 获取运用到当前class上的所有 注解
		Annotation[] annotations = clazz.getDeclaredAnnotations();
		System.out.println("Class" + clazz.getSimpleName() + "has "
				+ annotations.length + " annotations.");
	}

	/**
	 * 构造器操作
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
		 * Constructor<T> getConstructor(Class<?>... parameterTypes) 返回一个
		 * Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。
		 */
		Constructor constructor = clazz.getConstructor(null); // 无参构造器

		Constructor constructor2 = clazz.getConstructor(String.class,
				String.class, String.class); // 三个String类型的参数构造器

		/*
		 * Constructor<?>[] getConstructors() 返回一个包含某些 Constructor 对象的数组，这些对象反映此
		 * Class 对象所表示的类的所有公共构造方法。
		 */
		Constructor[] cons = clazz.getConstructors();
		System.out.println("公共构造器常量为：" + cons.length);

		/*
		 * Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
		 * 返回一个 Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法。
		 * 这个可以得到所有在这个类内定义的构造器，不管是不是public 的
		 */
		Constructor[] constructs = clazz.getDeclaredConstructors();
		System.out.println("公共构造器数量为:" + constructs.length);

		Constructor cons2 = clazz.getDeclaredConstructor(String.class,
				String.class, String.class);

		/**
		 * 构造器上的注解
		 */
		Annotation[] annos = cons2.getAnnotations();
		System.out.println("此构造器上的注解个数为：" + annos.length);
		Function function = (Function) cons2.getAnnotation(Function.class);
		System.out.println("Function 注解:" + function.value());

		/**
		 * 获取此构造器抛出的异常信息
		 */
		Class[] exceptions = cons2.getExceptionTypes();
		System.out.println("-----构造器抛出来的异常共有:" + exceptions.length
				+ "个。如下：----");
		for (Class c : exceptions) {
			System.out.println(c.getSimpleName());
		}

		/*
		 * Type[] getGenericExceptionTypes() 返回一组 Type 对象，这些对象表示声明要由此
		 * Constructor 对象抛出的异常
		 */
		System.out.println("----------构造器的Generic Exception Types-----------");
		Type[] types = cons2.getGenericExceptionTypes();
		for (Type t : types) {
			System.out.println(t.toString());
		}

		/*
		 * Type[] getGenericParameterTypes() 按照声明顺序返回一组 Type 对象，这些对象表示此
		 * Constructor 对象所表示的方法的形参类型。
		 */
		System.out.println("------------构造器方法形参的数据类型数组为：-----------");
		Type[] types2 = cons2.getGenericParameterTypes();
		for (Type t : types2) {
			System.out.println(t.toString());
		}

		/*
		 * Class<?>[] getParameterTypes() 按照声明顺序返回一组 Class 对象，这些对象表示此
		 * Constructor 对象所表示构造方法的形参类型。
		 */

		/*
		 * public int getModifiers() 以整数形式返回此 Constructor 对象所表示构造方法的 Java
		 * 语言修饰符。应该使用 Modifier 类对这些修饰符进行解码。
		 */
		System.out.println("--------------构造器的修饰符是：--------------");
		System.out.println(cons2.getModifiers());
		if (Modifier.isPublic(cons2.getModifiers())) {
			System.out.println("Modifier is public ");
		}

		/*
		 * String getName() 以字符串形式返回此构造方法的名称。
		 */
		String constructorName = cons2.getName();
		System.out.println("-----------此构造器的名称是：" + constructorName);

		/*
		 * Class<T> getDeclaringClass() 返回 Class 对象，该对象表示声明由此 Constructor
		 * 对象表示的构造方法的类。 即返回这个构造器所在的类
		 */
		Class parent = cons2.getDeclaringClass();
		System.out.println("----------此构造器所在的类是：");
		System.out.println(parent.getCanonicalName());

		/*
		 * boolean isVarArgs() 如果声明此构造方法可以带可变数量的参数，则返回 true；否则返回 false。
		 */
		System.out.println("参数列表是否支持可变变量：" + cons2.isVarArgs());

		/*
		 * 通过constructor对象创建对象 T newInstance(Object... initargs)
		 */
		Human human = (Human) cons2.newInstance(new String("louis"),
				new String("yellow"), new String("nationality"));
		System.out.println("Human's name is " + human.getName());
	}

	/**
	 * Field相关操作
	 * 
	 * @throws Exception
	 */
	private static void fieldOperations() throws Exception {
		Class clazz = Human.class;

		// 返回类内定义的所有成员字段，返回一个数组，包括私有成员字段
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(clazz.getSimpleName() + " 定义的成员字段共有："
				+ fields.length);
		// 获取类内定义的 指定名称的成员字段 包括私有成员字段
		Field field = clazz.getDeclaredField("name");

		// 返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段。
		// 包括从父类继承过来的可访问的字段
		Field[] fields1 = clazz.getFields();
		// 返回一个 Field 对象，它反映此 Class 对象所表示的类或接口的指定公共成员字段。
		// 包括从父类继承过来的可访问的字段
		Field field2 = clazz.getField("birthDate");
		Human human = new Human("lou", "yellow", "China", "1991-10");

		/*
		 * 获取human对象的对应字段的值 Object get(Object obj) XXX getXXX(Object obj) XXX
		 * Boolean,Byte,Char,Double,Long,Float,Int,Short 等
		 */
		Object value = field2.get(human);
		System.out.println("human对应字段 " + field2.getName() + " 的值为：" + value);

		/*
		 * 设置human对象的对应字段的值 void set(Object obj, Object value) void
		 * setXXX(Object obj, XXX z) XXX
		 * Boolean,Byte,Char,Double,Long,Float,Int,Short 等
		 */
		field2.set(human, "1990-1");
		System.out.println("human 对象的值已经被设定为：" + field2.get(human));

		/*
		 * 获取成员字段的数据类型 Class<?> getType() Type getGenericType()
		 */
		Class type = field2.getType();
		System.out.println("字段" + field2.getName() + " 的类型是:" + type.getName());
	}

	/**
	 * Method 相关操作
	 * @throws Exception 
	 */
	private static void methodOperations() throws Exception {
		Class clazz = Human.class;

		// 返回一个包含某些 Method 对象的数组，这些对象反映此 Class
		// 对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
		Method[] methods = clazz.getMethods();
		// 返回一个Method对象，它反映此Class对象上表示的类或接口的指定公共成员方法
		Method method = clazz.getMethod("speak", null);

		// 返回 Method 对象的一个数组，这些对象反映此 Class
		// 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
		Method[] methods2 = clazz.getDeclaredMethods();
		// 返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法
		Method method2 = clazz.getDeclaredMethod("walk", null);

		/*
		 * Object invoke(Object obj, Object... args) 对带有指定参数的指定对象调用由此 Method
		 * 对象表示的底层方法。 调用某个对象的这个方法
		 */
		Human human = new Human("lou", "yellow", "China", "1991-10");
		method2.invoke(human, null);
	}

}
