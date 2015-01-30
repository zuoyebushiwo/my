package com.company.target.pattern.ch06.command.remote;

/**
 * ¿ÍÌüµÆ
 */
public class LivingroomLightOffCommand implements Command {
	Light light;

	public LivingroomLightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}
}
