package com.company.target.pattern.ch12.combining.decorator;

public class MallardDuck implements Quackable {
 
	public void quack() {
		System.out.println("Quack");
	}
 
	public String toString() {
		return "Mallard Duck";
	}
}
