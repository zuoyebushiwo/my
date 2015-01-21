package com.company.target.collections.ch01;

import java.util.StringTokenizer;

import com.company.target.collections.general.GUI;
import com.company.target.collections.general.Process;

public class CalendarTester implements Process {

	final String PROMPT = "\n\nEnter in date 1, (in format year month day for example 1995 8 25)"
			+ "\nClose this window to quit.";

	GUI gui;

	// Postcondition: this CalendarTester object has been initialized.
	public CalendarTester() {

		gui = new GUI(this);
		gui.println(PROMPT);

	} // default constructor

	// Postcondition: the input for this CalendarTester has been processed.
	public void processInput(String s) {

		StringTokenizer st = new StringTokenizer(s);

		CalendarDate date1 = new CalendarDate(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st
						.nextToken()));

		if (!date1.isValid()) {

			gui.println("Invalid date entered.  Please enter a valid date.");
			gui.println(PROMPT);

		} // if
		else {

			CalendarDate date2 = new CalendarDate(2000, 1, 1);

			gui.println("Date 1 is: " + date1);

			gui.println("Date 2 is: " + date2);

			gui.println("\nThe day of the week of date 1 is: "
					+ date1.dayName());
			gui.println("The day before date 1 is: " + date1.previous());
			gui.println("The day after date 1 is: " + date1.next());

			if (date1.isPriorTo(date2))
				gui.println("Date 1 is prior to date 2");
			else
				gui.println("Date 1 is not prior to date 2");
			gui.println(PROMPT);

		} // else

	} // method processInput

} // class CalendarTester
