package com.company.target.collections.ch07;

/**
 * ≥µ¡æ–≈œ¢
 */
public class Car {

	protected int arrivalTime;

	// The Car has been constructed.
	public Car() {

	}

	// The car has been constructed from the arrival time.
	public Car(int nextArrivalTime) {

		arrivalTime = nextArrivalTime;

	} // constructor with int parameter

	// Postcondition: The arrival time of the Car has been returned.
	public int getArrivalTime() {

		return arrivalTime;

	} // method getArrivalTime

} // class Car
