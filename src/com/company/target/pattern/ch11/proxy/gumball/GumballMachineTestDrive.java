package com.company.target.pattern.ch11.proxy.gumball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMachineTestDrive {

	public static void main(String[] args) throws MalformedURLException {

		try {
			GumballMachine gumballMachine = new GumballMachine("до╡Щ", 100);

			System.out.println(gumballMachine);

			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();
			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();

			System.out.println(gumballMachine);

			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();
			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();

			System.out.println(gumballMachine);

			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();
			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();

			System.out.println(gumballMachine);

			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();
			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();

			System.out.println(gumballMachine);

			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();
			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();

			System.out.println(gumballMachine);
			
//			monitor.report();
			
			Naming.rebind("//" + "10.1.32.177" + "/gumballmachine", gumballMachine);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
