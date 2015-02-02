package com.company.target.pattern.ch09.iterator.dinermerger;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ¼å±ýÎÝ
 */
public class PancakeHouseMenuIterator implements Iterator<MenuItem> {

	ArrayList<MenuItem> items;
	int position = 0;

	public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.size()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = items.get(position);
		position = position + 1;
		return menuItem;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
