package com.company.target.pattern.ch06.command.remote;

public class RemoteLoader {

	public static void main(String[] args) {
		RemoteControl control = new RemoteControl();
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("");
		Stereo stereo = new Stereo("Living Room");

		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(
				livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(
				ceilingFan);

		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(
				garageDoor);

		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);

		control.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		control.setCommand(1, kitchenLightOn, kitchenLightOff);
		control.setCommand(2, ceilingFanOn, ceilingFanOff);
		control.setCommand(3, stereoOnWithCD, stereoOff);

		System.out.println(control);

		control.onButtonWasPushed(0);
		control.offButtonWasPushed(0);
		control.onButtonWasPushed(1);
		control.offButtonWasPushed(1);
		control.onButtonWasPushed(2);
		control.offButtonWasPushed(2);
		control.onButtonWasPushed(3);
		control.offButtonWasPushed(3);
	}

}
