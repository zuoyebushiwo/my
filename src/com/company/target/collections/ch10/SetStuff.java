package com.company.target.collections.ch10;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import com.company.target.collections.general.GUI;

/**
 * 
 */
public class SetStuff implements com.company.target.collections.general.Process {

	GUI gui;

	// Postcondition: this SetStuff instance has been initialized.
	public SetStuff() {

		final String PROMPT = "Please press the Enter key to run this program.\n";

		gui = new GUI(this);
		gui.println(PROMPT);

	} // default constructor

	@Override
	public void processInput(String s) {
		final String START = "Here is the TreeSet:\n";

		final String ADD = "After adding \"tranquil\", here is the TreeSet:\n";

		final String REMOVE = "After removing \"serene\", here is the TreeSet:\n";

		final String REVERSE = "\nHere are the scores in decreasing order:\n";

		final String SUM = "The sum of the scores is ";

		final String CLOSE_WINDOW_PROMPT = "\n\nPlease close this window when you are ready.";

		TreeSet mySet = new TreeSet();
		TreeSet scores = new TreeSet(new Decreasing());
		
		mySet.add ("happy");
        mySet.add ("always");
        mySet.add ("yes");
        mySet.add ("serene");
        System.out.println (START + mySet);
        
        if (mySet.add ("happy"))
            System.out.println ("ooops");
        else
            System.out.println ("happy was not added because it was already there");
        mySet.add ("tranquil");
        System.out.println (ADD + mySet);
        System.out.println ("size = " + mySet.size());
        if (mySet.contains ("no"))
            System.out.println ("How did \"no\" get in there?");
        else
            System.out.println ("\"no\" was not removed because it was not there");
        if (mySet.remove ("serene"))
            System.out.println (REMOVE + mySet);

        for (int i = 0; i < 5; i++)
            scores.add (new Integer (i));
        System.out.println (REVERSE + scores);
        
        Iterator itr = scores.iterator();
        int sum = 0;
        while (itr.hasNext())
            sum += ((Integer)itr.next()).intValue();
        System.out.println (SUM + sum + CLOSE_WINDOW_PROMPT);
        gui.freeze();
	}

}

@SuppressWarnings("rawtypes")
class Decreasing implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {

		return ((Integer) o2).compareTo((Integer) o1);

	}

}
