package com.company.target.pattern.ch09.iterator.dinermerger;

import java.util.Iterator;

/**
 * 菜单迭代器模式
 */
public interface Menu {

	public Iterator<MenuItem> createIterator();
	
}
