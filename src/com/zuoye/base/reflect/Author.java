package com.zuoye.base.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 对书写的类或者方法进行标识
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Author {
	String id() default "none";
	String name() default "none";
	String date();
}
