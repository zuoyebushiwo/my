package com.company.target.pattern.ch10.gumballstate;

/**
 * 金额足以支付
 */
public class HasQuarterState implements State {

	GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	/**
	 * 放入金币
	 */
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}

	/**
	 * 弹出剩余金币
	 */
	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setState(gumballMachine.getSoldState());
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
