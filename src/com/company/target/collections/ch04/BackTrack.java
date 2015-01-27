package com.company.target.collections.ch04;

import java.util.Iterator;

public class BackTrack {

	Application app;

	// Postcondition: this BackTrack has been initialized from app.
	public BackTrack(Application app) {

		this.app = app;

	} // constructor

	// Postcondition: a solution going through pos has been attempted.
	public boolean tryToSolve(Position pos) {

		boolean success = false;

		Iterator<Position> itr = app.iterator(pos);

		while (!success && itr.hasNext()) {

			pos = itr.next();
			if (app.valid(pos)) {

				app.record(pos);
				if (app.done(pos))
					success = true;
				else {

					success = tryToSolve(pos);
					if (!success)
						app.undo(pos);

				} // not done

			} // a valid position

		} // while
		return success;

	} // method tryToSolve

}