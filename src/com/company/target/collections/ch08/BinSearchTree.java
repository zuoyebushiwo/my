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

	/**
	 * 增加元素
	 */
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
				comp = ((Comparable) o).compareTo(temp.element);

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

	/**
	 * 移出元素
	 */
	@Override
	public boolean remove(Object elem) {
		Entry<E> e = getEntry(elem);
		if (e == null) {
			return false;
		}
		deleteEntry(e);
		return true;
	}

	private void deleteEntry(Entry<E> p) {
		size--;
		if (p.left != null && p.right != null) {
			Entry<E> s = successor(p);
			p.element = s.element;
			p = s;
		}
		Entry<E> replacement;
		if (p.left != null)
			replacement = p.left;
		else
			replacement = p.right;

		// If p has at least one child, link replacement to p.parent.
		if (replacement != null) {

			replacement.parent = p.parent;
			if (p.parent == null)
				root = replacement;
			else if (p == p.parent.left)
				p.parent.left = replacement;
			else
				p.parent.right = replacement;

		} // p has at least one child
		else if (p.parent == null)
			root = null;
		else {

			if (p == p.parent.left)
				p.parent.left = null;
			else if (p == p.parent.right)
				p.parent.right = null;

		} // p has a parent but no children
	}

	/**
	 * 查找某个元素
	 * 
	 * @param elem
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Entry<E> getEntry(Object elem) {
		int comp;
		Entry<E> e = root;
		while (e != null) {
			comp = ((Comparable<Object>) elem).compareTo(e.element);
			if (comp == 0)
				return e;
			else if (comp < 0)
				e = e.left;
			else
				e = e.right;
		} // while
		return null;
	}

	private Entry<E> successor(Entry<E> e) {
		if (e == null) {
			return null;
		} else if (e.right != null) {
			Entry<E> p = e.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		} else {
			Entry<E> p = e.parent;
			Entry<E> ch = e;
			while (p != null && ch == p.right) {
				ch = p;
				p = p.parent;
			}
			return p;
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
