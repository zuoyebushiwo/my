package com.zuoye.base.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// ����д������߷������б�ʶ
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Author {
	String id() default "none";
	String name() default "none";
	String date();
}
