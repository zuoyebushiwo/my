package com.company.target.collections.ch07;


/**
 * ���кͶ�ջ
 */
public class Test {

	public static void main(String[] args) {
		Queue<Object> queue = new Queue<Object>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		
		queue.dequeue();
		
		System.out.println(queue.front());
	}
	
}
