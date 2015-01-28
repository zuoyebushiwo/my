package com.company.target.collections.ch11;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap implements PriorityQueue {

	protected int size;
	protected Object[] heap;
	protected Comparator<Object> comparator;

	public Heap() {
		final int DEFAULT_INITIAL_CAPACITY = 11;
		heap = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public Heap(Comparator<Object> comparator) {
		this();
		this.comparator = comparator;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void add(Object element) {
		if (++size == heap.length) {
			Object[] newHeap = new Object[2 * heap.length];
			System.arraycopy(heap, 0, newHeap, 0, heap.length);
			heap = newHeap;
		}
		heap[size - 1] = element;
		percolateUp();
	}

	@Override
	public Object getMin() {
		if (size == 0) {
			throw new NoSuchElementException("Priority queue empty.");
		}
		return heap[0];
	}

	@Override
	public Object removeMin() {
		if (size == 0)
			throw new NoSuchElementException("Priority queue empty.");
		Object minElem = heap[0];
		heap[0] = heap[size - 1];
		heap[--size] = minElem;
		percolateDown(0);
		return minElem;
	}

	// Precondition: heap is a heap except, possibility, at index size - 1.
	// Postcondition: heapity has been restored to heap.
	protected void percolateUp() {
		int child = size - 1, parent;
		Object temp;

		while (child > 0) {
			parent = (child - 1) / 2;
			if (compare(heap[parent], heap[child]) <= 0)
				break;
			temp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = temp;
			child = parent;
		}

	}

	// Postcondition: an int < 0, == 0 or > 0 has been returned,
	// according to whether elem1 is less than,
	// equal to or greater than elem2.
	@SuppressWarnings("unchecked")
	protected int compare(Object elem1, Object elem2) {
		return (comparator == null ? ((Comparable<Object>) elem1)
				.compareTo(elem2) : comparator.compare(elem1, elem2));
	}

	// Precondition: the complete binary tree rooted at start is a
	// heap except, possibly, at index start.
	// Postcondition: heapity has been restored to heap
	protected void percolateDown(int start) {
		int child, parent = start;
		Object temp;

		while ((child = 2 * parent + 1) < size) {

			if (child < size - 1 && compare(heap[child], heap[child + 1]) > 0)
				child++; // child indexes smallest child
			if (compare(heap[parent], heap[child]) <= 0)
				break;
			temp = heap[child];
			heap[child] = heap[parent];
			heap[parent] = temp;
			parent = child;

		} // while
	}

	public void heapSort(Object[] a) {
		Object temp;

		int length = a.length, i;

		heap = a;
		size = length;
		for (i = length / 2 - 1; i >= 0; i--)
			percolateDown(i);
		while (size > 0)
			removeMin();
		for (i = 0; i < length / 2; i++) {

			temp = heap[i];
			heap[i] = heap[length - i - 1];
			heap[length - i - 1] = temp;

		} // reversing heap
		System.out.println("length = " + length);
		for (i = 0; i < length; i++)
			System.out.print(heap[i]);
	}

}
