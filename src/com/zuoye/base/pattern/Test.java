package com.zuoye.base.pattern;

public class Test {

	public void test() {
		short s1 = 1; s1 += 1;
	}
	
}

interface Playable {
	void play();
}

interface Bounceable {
	void play();
}

interface Rollable extends Playable, Bounceable {
	Ball ball = new Ball("PingPang");
}

class Ball implements Rollable {
	private String name;

	public String getName() {
		return name;
	}

	public Ball(String name) {
		this.name = name;
	}

	public void play() {
		// ball = new Ball("Football");
		System.out.println(ball.getName());
	}
}