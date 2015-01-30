package com.company.target.pattern.ch06.command.undo;

/**
 * 命令接口
 */
public interface Command {

	/**
	 * 执行
	 */
	public void execute();
	
	/**
	 * 撤销 
	 */
	public void undo();
	
}
