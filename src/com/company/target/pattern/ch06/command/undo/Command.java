package com.company.target.pattern.ch06.command.undo;

/**
 * ����ӿ�
 */
public interface Command {

	/**
	 * ִ��
	 */
	public void execute();
	
	/**
	 * ���� 
	 */
	public void undo();
	
}
