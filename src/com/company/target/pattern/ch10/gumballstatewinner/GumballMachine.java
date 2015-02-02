package com.company.target.pattern.ch10.gumballstatewinner;

/**
 * �ǹ�������
 */
public class GumballMachine {

	/**
	 * ����
	 */
	State soldOutState;

	/**
	 * ��Ǯ����
	 */
	State noQuarterState;

	/**
	 * ����֧��
	 */
	State hasQuarterState;

	/**
	 * �����۳�
	 */
	State soldState;
	
	/**
	 * ���˶�
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
	 * �������
	 */
	public void insertQuarter() {
		state.insertQuarter();
	}

	/**
	 * �������
	 */
	public void ejectQuarter() {
		state.ejectQuarter();
	}

	/**
	 * ת������
	 */
	public void turnCrank() {
		state.turnCrank();
		// �·��ǹ�
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}

	/**
	 * �ͷ��ǹ�
	 */
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	/**
	 * ��ȡ�ǹ���ʣ���ǹ�����
	 * 
	 * @return
	 */
	int getCount() {
		return count;
	}

	/**
	 * ����װ���ǹ�
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
