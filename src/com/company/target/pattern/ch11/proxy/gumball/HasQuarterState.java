package com.company.target.pattern.ch11.proxy.gumball;

import java.util.Random;

/**
 * �������֧��
 */
public class HasQuarterState implements State {

	GumballMachine gumballMachine;
	Random randomWinner = new Random(1);

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	/**
	 * ������
	 */
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}

	/**
	 * ����ʣ����
	 */
	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(1);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	@Override
	public String toString() {
		return "waiting for turn of crank";
	}

}
