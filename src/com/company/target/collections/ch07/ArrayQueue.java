package com.company.target.collections.ch07;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {

	protected E[] data;
	protected int size, head, tail;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		final int INITAL_LENGTH = 100;
		data = (E[]) new Object[INITAL_LENGTH];
		size = 0;
		head = 0;
		tail = -1;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E front() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return data[head];
	}

	public void enqueue(E element) {
		if (size == data.length) {
			Object[] oldData = data;
			data = (E[]) new Object[data.length * 2];
			System.arraycopy(oldData, head, data, 0, oldData.length - head);

			if (head > 0) {
				System.arraycopy(oldData, 0, data, head + 1, tail + 1);
			}
		}
	}

}
