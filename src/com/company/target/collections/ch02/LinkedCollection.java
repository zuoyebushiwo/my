package com.company.target.collections.ch02;

import java.util.Collection;
import java.util.Iterator;

public class LinkedCollection<E> implements Collection<E> {
	
	public static void main(String[] args) {
		LinkedCollection<Object> myLinked = new LinkedCollection<Object>();
		myLinked.add("a");
		myLinked.add("b");
		myLinked.add("c");
		Iterator<Object> iterator = myLinked.iterator();
		while (iterator.hasNext()) {
			Object o = (Object) iterator.next();
			System.out.println(o);
		}
		System.out.println();
	}
	
	protected Entry head;

	public LinkedCollection() {
		
	}
	
	protected static class Entry<E> {
		E element;
		Entry next;
	}
	
	@SuppressWarnings("hiding")
	private class LinkedCollectionIterator<E> implements Iterator<E> {
		
		Entry next;
		
		LinkedCollectionIterator() {
			next = head;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public E next() {
			E theElement = (E) next.element;
			next = next.next;
			return theElement;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	
	@Override
	public int size() {
		int count = 0;
		for (Entry current = head; current != null; current = current.next)
			count++;
		return count;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(Object o) {
		for (Entry current = head; current != null; current = current.next)
			if (current.element.equals(o)) {
				return true;
			}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedCollectionIterator<E>();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] paramArrayOfT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E o) {
		Entry newEntry = new Entry();
		newEntry.element = o;
		newEntry.next = head;
		head = newEntry;
		return true;
	}

	@Override
	public boolean remove(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> paramCollection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
