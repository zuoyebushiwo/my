package com.company.target.pattern.ch11.proxy.gumball;

import java.rmi.RemoteException;

/**
 * 糖果售卖机的库存以及状态监视
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
