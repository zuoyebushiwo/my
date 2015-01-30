package com.company.target.pattern.ch06.command.simpleremote;


/**
 * 打开电灯的命令
 */
public class LightOnCommand implements Command {

	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.on();
	}

}
