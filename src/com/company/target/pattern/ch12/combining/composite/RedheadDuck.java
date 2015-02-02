package com.company.target.pattern.ch12.combining.composite;

public class RedheadDuck implements Quackable {
	public void quack() {
		System.out.println("Quack");
	}

	public String toString() {
		return "Redhead Duck";
	}
}
