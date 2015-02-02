package com.company.target.pattern.ch11.proxy.gumball;

import java.rmi.RemoteException;

/**
 * �ǹ��������Ŀ���Լ�״̬����
 */
public class GumballMonitor {

	GumballMachineRemote machine;

	public GumballMonitor(GumballMachineRemote machine) {
		this.machine = machine;
	}

	public void report() throws RemoteException {
		System.out.println("Gumball Machine: " + machine.getLocation());
		System.out.println("Current inventory: " + machine.getCount()
				+ " gumballs");
		System.out.println("Current state: " + machine.getState());
	}

}
