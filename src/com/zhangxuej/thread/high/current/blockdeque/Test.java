package com.zhangxuej.thread.high.current.blockdeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Java�̣߳�������-����ջ
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		BlockingDeque<Integer> bDeque = new LinkedBlockingDeque<Integer>(20);
		for (int i = 0; i < 30; i++) {
			// ��ָ��Ԫ����ӵ�������ջ�У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ��
			bDeque.putFirst(i);
			System.out.println("������ջ�������Ԫ�أ�" + i);
		}
		System.out.println("���򵽴����н����������Ƴ�---");
	}

}
