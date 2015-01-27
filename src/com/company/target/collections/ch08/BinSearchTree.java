package com.company.target.collections.ch08;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * 二叉搜索树
 * 
 * @param <E>
 */
public class BinSearchTree<E> extends AbstractSet<E> {
	
	// 根节点
	protected Entry<E> root;
	protected int size;

	@Override
	public Iterator<E> iterator() {
		return new TreeIterator();
	}

	@Override
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		Entry<E> e = root;
		int comp;
		
		while (e != null) {
			comp = ((Comparable<E>) o).compareTo(e.element);
			if (comp == 0) {
				return true;
			} else if (comp < 0) {
				e = e.left;
			} else {
				e = e.right;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E o) {
		if (root == null) { // empty tree
			root = new Entry<E>(o, null);
			size++;
			return true;
		} else {
			Entry<E> temp = root;
			int comp;
			
			while (true) {
				comp = ((Comparable<Entry<E>>) o).compareTo(temp);
				
				if (comp == 0) {
					return false;
				}
				
				if (comp < 0) {
					if (temp.left != null) {
						temp = temp.left;
					} else {
						temp.left = new Entry<E>(o, temp);
						size++;
						return true;
					}
				} else if (temp.right != null) {
					temp = temp.right;
				} else {
					temp.right = new Entry<E>(o, temp);
					size++;
					return true;
				}
			}
		}
	}

	private static class Entry<E> {
		E element;
		Entry<E> left = null, right = null, parent = null;

		// Postcondition: this Entry has been initialized from element and
		// parent.
		public Entry(E element, Entry<E> parent) {
			this.element = element;
			this.parent = parent;
		}
	}
	
	private class TreeIterator implements Iterator<E> {
		private Entry<E> lastReturned = null;
		private Entry<E> next;
		
		@SuppressWarnings("unchecked")
		public TreeIterator() {
			next = (Entry<E>) root;
			if (next != null) {
				while (next.left != null) {
					next = next.left;
				}
			}
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public E next() {
			lastReturned = next;
			next = successor(next);
			return lastReturned.element;
		}

		@Override
		public void remove() {
			if (lastReturned.left != null && lastReturned != null) {
				next = lastReturned;
			}
			deleteEntry(lastReturned);
		    lastReturned = null;
		}
		
	}

}
