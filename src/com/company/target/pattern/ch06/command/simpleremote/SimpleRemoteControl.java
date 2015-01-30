package com.company.target.pattern.ch06.command.simpleremote;

/**
 *
 */
public class SimpleRemoteControl {

	Command slot;

	public SimpleRemoteControl() {

	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}

}
