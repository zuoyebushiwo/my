package com.company.target.collections.ch04;

import com.company.target.collections.general.GUI;
import com.company.target.collections.general.Process;

public class BinarySearchTest implements Process {

    final String ARRAY_MESSAGE =
        "The array on which binary searches will be performed is:\n" +
        "Ada, Ben, Carol, Dave, Ed, Frank, Gerri, Helen, Iggy, Joan";

    final String PROMPT =
        "\n\nIn the input line, enter a name to be searched for in the array.";

    GUI gui;

    // Postcondition: The calling object has been initialized.
    public BinarySearchTest() {

        gui = new GUI (this);
        gui.print (ARRAY_MESSAGE);
        gui.print (PROMPT);

    } // constructor


    // Postcondition: A binary search for the name s has been performed.
    public void processInput (String s) {

        final String[] a = {"Ada", "Ben", "Carol", "Dave", "Ed", "Frank",
                           "Gerri", "Helen", "Iggy", "Joan"};

        final String FOUND = "\nThat name was found at index ";

        final String NOT_FOUND = "\nThat name was not found, but could be " +
                                 "inserted at index ";

        int index = binarySearch (a, 0, a.length - 1, s);
        if (index >= 0)
            gui.print (FOUND + index);
        else
            gui.print (NOT_FOUND + (-index - 1));
        gui.print (PROMPT);

    } // method processInput


    // Precondition: The array, from first to last, is sorted according to the
    //               compareTo method in the class of which key is an object.
    // Postcondition: If there is an index i in the array a such that
    //                ((Comparable) a [i]).compareTo (key) == 0, then i has been
    //                returned.  Otherwise, -insertionPoint - 1 has been
    //                returned, where insertionPoint is the smallest index where
    //                key could be inserted without disordering the array.
    public static int binarySearch(Object[] a, int first, int last, Object key){

        if (first <= last) {

            int mid = (first + last) / 2;
            Object midVal = a [mid];
            int comp = ((Comparable)midVal).compareTo (key);
            if (comp < 0)
                return binarySearch (a, mid + 1, last, key);
            if (comp > 0)
                return binarySearch (a, first, mid - 1, key);
            return mid;  // key found

        } // if first <= last
        return -first - 1; // key not found; belongs at a [first]

    } // method binarySearch


} // class BinarySearchTest