package com.company.target.pattern.ch06.command.simpleremote;

public class RemoteControlTest {
	
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand(light);
		
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		
		GarageDoor garageDoor = new GarageDoor();
		GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
		remote.setCommand(garageDoorOpen);
		remote.buttonWasPressed();
	}

}
