package com.company.target.collections.ch07;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

import com.company.target.collections.general.GUI;
import com.google.code.yanf4j.util.SimpleQueue;

/**
 * Ä£ÄâÏ´³µ
 */
public class CarWash implements com.company.target.collections.general.Process {

	protected final String PROMPT = "\nIn the Input line, please enter "
			+ "the next arrival time.  The sentinel is ";

	protected final int ILLEGAL_INPUT = -1;

	protected final int SENTINEL = 999;

	protected final int INFINITY = 10000; // indicates no car being washed

	protected final int MAX_SIZE = 5; // maximum cars allowed in carQueue

	protected final int WASH_TIME = 10; // minutes to wash one car

	protected GUI gui;

	protected Queue<Car> carQueue;

	protected int currentTime, nextDepartureTime, numberOfCars,
			sumOfWaitingTimes;

	// The CarWash has been initialized.
	public CarWash() {

		gui = new GUI(this);
		carQueue = new SimpleQueue<Car>();
		currentTime = 0;
		numberOfCars = 0;
		sumOfWaitingTimes = 0;
		nextDepartureTime = INFINITY;
		gui.println(PROMPT + SENTINEL);

	} // constructor

	// Postcondition: The next arrival time, in the string s, has been
	// processed.
	@Override
	public void processInput(String s) {
		int nextArrivalTime;

		gui.println(s);
		nextArrivalTime = parseOK(s);
		if (nextArrivalTime != ILLEGAL_INPUT)
			if (nextArrivalTime != SENTINEL) {

				while (nextArrivalTime >= nextDepartureTime)
					processDeparture();
				processArrival(nextArrivalTime);
				gui.println(PROMPT + SENTINEL);

			} // processing next arrival
			else { // process any cars remaining on the queue:

				while (nextDepartureTime < INFINITY)
					processDeparture();
				printResult();
				gui.freeze();

			} // processing cars still on queue after last arrival
		else
			gui.println(PROMPT + SENTINEL);
	}

	// Postcondition: if a legal value for next arrival time has been
	// obtained from the Input line, that value has been
	// returned. Otherwise, ILLEGAL_INPUT has been returned.
	protected int parseOK(String s) {

		final String INTEGER_NEEDED = "\nThe input line should consist of an integer.";

		StringTokenizer tokens = new StringTokenizer(s);

		try {

			return Integer.parseInt(tokens.nextToken());

		} // try
		catch (NoSuchElementException e) {

			gui.println(e + INTEGER_NEEDED);

		} // catch not enough input
		catch (NumberFormatException e) {

			gui.println(e + INTEGER_NEEDED);

		} // input not in integer form
		return ILLEGAL_INPUT;

	} // method parseOK

	// Postcondition: A car has arrived and has either been turned away --
	// if the Queue was full before this message was sent --
	// or has entered the car wash.
	protected void processArrival(int nextArrivalTime) {

		final String OVERFLOW = "Overflow";

		currentTime = nextArrivalTime;
		if (carQueue.size() == MAX_SIZE)
			gui.print(OVERFLOW);
		else {

			numberOfCars++;
			if (nextDepartureTime == INFINITY)
				nextDepartureTime = currentTime + WASH_TIME;
			else
				carQueue.add(new Car(nextArrivalTime));

		} // not an overflow

	} // method processArrival

	// Postcondition: A car has finished getting washed.
	protected void processDeparture() {

		int arrivalTime, waitingTime;

		currentTime = nextDepartureTime;
		if (!carQueue.isEmpty()) {

			Car car = (Car) carQueue.poll();
			arrivalTime = car.getArrivalTime();
			waitingTime = currentTime - arrivalTime;
			sumOfWaitingTimes += waitingTime;
			nextDepartureTime = currentTime + WASH_TIME;

		} // carQueue was not empty
		else
			nextDepartureTime = INFINITY;

	} // method processDeparture

	// Postcondition: The average waiting time, or an errro message,
	// has been printed.
	protected void printResult() {

		final String NO_CARS_MESSAGE = "There were no cars in the car wash.";
		final String AVERAGE_WAITING_TIME_MESSAGE = "\n\nThe average waiting time, in minutes, was ";
		final String CLOSE_WINDOW_PROMPT = "\nThe execution of the project "
				+ "is finished. Please close this window when you want to.";

		if (numberOfCars == 0)
			gui.println(NO_CARS_MESSAGE);
		else
			gui.println(AVERAGE_WAITING_TIME_MESSAGE
					+ ((double) sumOfWaitingTimes / numberOfCars));
		gui.print(CLOSE_WINDOW_PROMPT);

	} // method printResult

}
