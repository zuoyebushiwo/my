package com.company.target.pattern.ch09.iterator.dinermerger;

import java.util.Iterator;

/**
 * �˵�������ģʽ
 */
public interface Menu {

	public Iterator<MenuItem> createIterator();
	
}
