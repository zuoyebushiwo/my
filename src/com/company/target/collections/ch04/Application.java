package com.company.target.collections.ch04;

import java.util.Iterator;

/**
 * »ØËÝ²ßÂÔµÄ¸ÅÀ¨
 */
public interface Application {

	// Postcondition: true has been returned if pos can be on
	// a path to a solution. Otherwise, false
	// has been returned.
	boolean valid(Position pos);

	// Postcondition: pos has been marked as possibly being on
	// a path to a solution.
	void record(Position pos);

	// Postcondition: true has been returned if pos represents
	// the finish state. Otherwise, false has
	// been returned.
	public boolean done(Position pos);

	// Postcondition: pos has been marked as not being on a
	// path to a solution.
	public void undo(Position pos);

	// Postcondition: a String representing this instance of
	// Cities has been returned.
	public String toString();

	// Postcondition: an Iterator starting at pos has been
	// returned.
	public Iterator<Position> iterator(Position pos);

} // interface Application 
