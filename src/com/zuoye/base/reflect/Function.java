package com.zuoye.base.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//¹¦ÄÜÃèÊö  
@Retention(value=RetentionPolicy.RUNTIME) 
public @interface Function {
	
	String value() default "none";

}
