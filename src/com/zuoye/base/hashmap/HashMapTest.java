package com.zuoye.base.hashmap;

import java.util.HashMap;

/**
 * HashMap的设计原理和实现分析
 * 
 * 1.HashMap的设计思路和内部结构组成 2.HashMap中的一些概念：什么是阀值？为什么会有阀值？什么是加载因子？他们有什么作用
 * 3.HashMap的性能问题以及使用事项 4.HashMap的源码实现和分析 5.为什么JDK建议我们重写Object.equals(Object
 * obj)方法时，需要保证对象可以返回相同的hashcode值
 * 
 */
public class HashMapTest<K, V> extends HashMap<K, V> {

	/**
	 * 1.HashMap设计思路以及内部结构组成
	 * 
	 * HashMap设计思路
	 * 
	 * Map<K, V>是一种以键值对存储数据的容器，而HashMap则是借助了键值Key的hashcode值来组织存储，
	 * 使得可以非常快速和高效地根据键值Key进行数据的存取。
	 * 
	 * 对于键值对<Key, Value>, HashMap内部会将其封装成一个对应的Entry<Key, Value>对象， 即Entry<Key,
	 * Value>对象是键值对<Key, Value>的组织形式；
	 * 
	 * 对于每个对象而言，JVM都会为其生成一个hashcode值。HashMap在存储键值对Entry<Key, Value>的时候，
	 * 会根据Key的hashCode值，以某种映射关系，决定应当将这对键值对Entry<Key, Value>存储在HashMap中的什么位置；
	 * 
	 * 当通过Key值取数据的时候，然后根据Key值的hashcode，以及内部映射条件，直接定位到Key对应的Value值存放在什么位置上，
	 * 可以非常高效地将Value值取出。
	 */

	/**
	 * 为了实现上述的设计思路，在HashMap内部，采用了数组+链表的形式来组织键值对Entry<Key, Value>。
	 * HashMap内部维护了一个Entry[] table数组，当我们使用new HashMap()创建一个HashMap时，Entry[]
	 * table的默认长度为16。Entry[] table的长度又被称 为这个HashMap的容量（capacity）； 对于Entry[]
	 * table的每个元素而言，或为null，或为由若干个Entry<Key, Value>组成的链表。HashMap中的Entry<Key,
	 * Value>的数目被称为HashMap的大小 （size）; Entry[] table中的某一个元素及其对应Entry<Key,
	 * Value>又被称为桶(bucket);
	 */
//	public static void main(String[] args) {
//		HashMap<String, String> map = new HashMap<String, String>();
//	}
//
//	/**
//	 * 将<Key, Vlaue>键值对存到HashMap中，如果Key在HashMap中已经存在，那么最终返回被替换掉的Value值。
//	 * Key和Value允许为空
//	 */
//	@Override
//	public V put(K key, V value) {
//		// 1.如果key为null，那么将此value放置到table[0]，即第一个桶种
//		if (key == null) {
//			return putForNullKey(value);
//		}
//		// 2.重新计算hashcode的值，
//		int hash = hash(key.hashCode());
//		// 3.计算当前hashcode的值应当被分配到哪一个桶中，获取桶的索引
//		int i = indexFor(hash, table.length);
//		// 4.循环遍历该桶中的Entry列表
//		for (Entry<K, V>  e = table[i] : e != null; e = e.next()) {
//			Object k;
//			// 5.查找Entry<Key, Value>链表中是否已经有了以Key值为Key存储的Entry<Key, Value>对象；
//			// 已经存在，则将Value值覆盖到对应的Entry<Key, Value>对象节点上
//			if (e.hash == hash && ((k = e.key) == key || key.equals(k))) { // 请读者注意这个判定条件，非常重要
//				V oldValue = e.value;
//				e.value = value;
//				e.recordAccess(this);
//				return oldValue;
//			}
//			
//		}
//		modCount++;
//		
//		// 6.不存在，则根据键值对<Key, Value> 创建一个新的Entry<Key, Value>对象，然后添加到这个桶的Entry<Key, Value>链表的头部。
//		addEntry(hash, key, value, i);
//		return null;
//	}
//
//	/**
//	 * Key为Null，则将Entry<null, Value>放置到第一个桶table[0]中
//	 * 
//	 * @param value
//	 * @return
//	 */
//	private V putForNullKey(V value) {
//		for (Entry<K, V> e = table[0]; e != null; e = e.next) {
//			if (e.key == null) {
//				V oldValue = e.value;
//				e.value = value;
//				e.recordAccess(this);
//				return oldValue;
//			}
//		}
//		modCount++;
//		addEntry(0, null, value, 0);
//		return null;
//	}
//
//	/** 
//	 * 根据特定的hashcode 重新计算hash值， 
//	 * 由于JVM生成的的hashcode的低字节(lower bits)冲突概率大，（JDK只是这么一说，至于为什么我也不清楚） 
//	 * 为了提高性能，HashMap对Key的hashcode再加工，取Key的hashcode的高字节参与运算 
//	 */  
//	static int hash(int h) {  
//	    // This function ensures that hashCodes that differ only by  
//	    // constant multiples at each bit position have a bounded  
//	    // number of collisions (approximately 8 at default load factor).  
//	    h ^= (h >>> 20) ^ (h >>> 12);  
//	    return h ^ (h >>> 7) ^ (h >>> 4);  
//	}  
//	  
//	/** 
//	 * 返回此hashcode应当分配到的桶的索引 
//	 */  
//	static int indexFor(int h, int length) {  
//	    return h & (length-1);  
//	} 
	
}
