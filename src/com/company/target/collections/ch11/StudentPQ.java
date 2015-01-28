package com.company.target.collections.ch11;

import com.company.target.collections.general.GUI;

public class StudentPQ implements
		com.company.target.collections.general.Process {

	protected final String PROMPT = "In the Input line, please enter "
			+ "a student's name and GPA. To quit, enter ";

	protected final String SENTINEL = "***";

	GUI gui;

	PriorityQueue pq;

	// Postcondition: this StudentPQ has been initialized.
	public StudentPQ() {

		gui = new GUI(this);
		pq = new Heap();
		gui.println(PROMPT + SENTINEL);

	} // default constructor

	@Override
	public void processInput(String s) {
		final String RESULTS = "\nHere are the student names and GPAs:";

		final String CLOSE_WINDOW_PROMPT = "\nThe execution of the project "
				+ "is completed. Please close this window when you are ready.";

		if (!s.equals(SENTINEL)) {

			gui.println(s + "\n");
			pq.add(new Student(s));
			gui.println(PROMPT + SENTINEL);

		} // if
		else {

			gui.println(RESULTS);
			while (!pq.isEmpty())
				gui.println(pq.removeMin());
			gui.println(CLOSE_WINDOW_PROMPT);

		} // else

	}

}
