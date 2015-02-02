package com.company.target.pattern.ch10.gumballstatewinner;

/**
 * 糖果售卖机
 */
public class GumballMachine {

	/**
	 * 售罄
	 */
	State soldOutState;

	/**
	 * 金钱不足
	 */
	State noQuarterState;

	/**
	 * 可以支付
	 */
	State hasQuarterState;

	/**
	 * 正在售出
	 */
	State soldState;
	
	/**
	 * 幸运儿
	 */
	State winnerState;
	
	State state = soldOutState;

	int count = 0;

	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);

		this.count = numberGumballs;

		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}

	/**
	 * 请放入金币
	 */
	public void insertQuarter() {
		state.insertQuarter();
	}

	/**
	 * 弹出金币
	 */
	public void ejectQuarter() {
		state.ejectQuarter();
	}

	/**
	 * 转动曲柄
	 */
	public void turnCrank() {
		state.turnCrank();
		// 下发糖果
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}

	/**
	 * 释放糖果
	 */
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	/**
	 * 获取糖果机剩余糖果数量
	 * 
	 * @return
	 */
	int getCount() {
		return count;
	}

	/**
	 * 重新装填糖果
	 * 
	 * @param count
	 */
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

	public State getState() {
		return state;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}
	
	public State getWinnerState() {
		return winnerState;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}

}
