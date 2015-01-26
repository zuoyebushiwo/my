package com.company.target.collections.ch07;

import java.util.LinkedList;

/**
 * ╤сап
 */
public class Queue<E> {
	
	protected LinkedList<E> list;
	
	public Queue() {
		list = new LinkedList<E>();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void enqueue(E element) {
		list.add(element);
	}
	
	public E dequeue() {
		return list.removeFirst();
	}
	
	public E front() {
		return list.getFirst();
	}
 
}
