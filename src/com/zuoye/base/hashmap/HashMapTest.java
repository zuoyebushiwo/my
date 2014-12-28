package com.zuoye.base.hashmap;

import java.util.HashMap;

/**
 * HashMap的设计原理和实现分析
 * 
 * 1.HashMap的设计思路和内部结构组成
 * 2.HashMap中的一些概念：什么是阀值？为什么会有阀值？什么是加载因子？他们有什么作用
 * 3.HashMap的性能问题以及使用事项
 * 4.HashMap的源码实现和分析
 * 5.为什么JDK建议我们重写Object.equals(Object obj)方法时，需要保证对象可以返回相同的hashcode值
 * 
 */
public class HashMapTest {
	
	/**
	 * 1.HashMap设计思路以及内部结构组成 
	 * 
	 * 		HashMap设计思路
	 * 
	 * 		Map<K, V>是一种以键值对存储数据的容器，而HashMap则是借助了键值Key的hashcode值来组织存储，
	 * 使得可以非常快速和高效地根据键值Key进行数据的存取。
	 * 
	 * 		对于键值对<Key, Value>, HashMap内部会将其封装成一个对应的Entry<Key, Value>对象，
	 * 即Entry<Key, Value>对象是键值对<Key, Value>的组织形式；
	 * 
	 * 		对于每个对象而言，JVM都会为其生成一个hashcode值。HashMap在存储键值对Entry<Key, Value>的时候，
	 * 会根据Key的hashCode值，以某种映射关系，决定应当将这对键值对Entry<Key, Value>存储在HashMap中的什么位置；
	 * 
	 * 		当通过Key值取数据的时候，然后根据Key值的hashcode，以及内部映射条件，直接定位到Key对应的Value值存放在什么位置上，
	 * 可以非常高效地将Value值取出。
	 */

	
	/**
	 * 为了实现上述的设计思路，在HashMap内部，采用了数组+链表的形式来组织键值对Entry<Key, Value>。
	 * HashMap内部维护了一个Entry[] table数组，当我们使用new HashMap()创建一个HashMap时，Entry[] table的默认长度为16。Entry[] table的长度又被称
	 * 为这个HashMap的容量（capacity）；
	 * 对于Entry[] table的每个元素而言，或为null，或为由若干个Entry<Key, Value>组成的链表。HashMap中的Entry<Key, Value>的数目被称为HashMap的大小
	 * （size）;
	 * Entry[] table中的某一个元素及其对应Entry<Key, Value>又被称为桶(bucket);
	 */
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
	}
	
}
