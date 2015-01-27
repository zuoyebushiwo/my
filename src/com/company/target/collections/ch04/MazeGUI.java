package com.company.target.collections.ch04;

import java.util.StringTokenizer;

import com.company.target.collections.general.GUI;
import com.company.target.collections.general.Process;;

public class MazeGUI implements Process {

    GUI gui;


    public MazeGUI() {

        final String PROMPT =
            "In the Input line, please enter the row and column of the " +
            "start position\nand the row and column of the finish position.";

        gui = new GUI (this);
        gui.println (PROMPT);

    } // default constructor


    // Postcondition: the input for this MazeGUI has been processed.
    public void processInput (String s) {

        final String INITIAL_STATE =
            "\nThe initial state is as follows (0 = WALL, 1 = CORRIDOR):\n";

        final String FINAL_STATE =
            "The final state is as follows (2 = TRIED, 9 = PATH):\n";

        final String SUCCESS =
            "\n\nA solution has been found:";

        final String FAILURE =
            "\n\nThere is no solution:";

        final String CLOSE_WINDOW_PROMPT =
            "Please close this window when you are ready.";

        byte[][] grid = {

            {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}

        }; // grid

        StringTokenizer st = new StringTokenizer (s);

        int startRow = Integer.parseInt (st.nextToken()),
            startColumn = Integer.parseInt (st.nextToken()),
            finishRow = Integer.parseInt (st.nextToken()),
            finishColumn = Integer.parseInt (st.nextToken());

        Position start = new Position (startRow, startColumn);
        Position finish = new Position (finishRow, finishColumn);

        Application app = new Maze (grid, finish);
        BackTrack backTrack = new BackTrack (app);

        gui.println (INITIAL_STATE + app);
        if (!app.valid (start) || !app.valid (finish))
            gui.println (FAILURE);
        else
        {
            app.record (start);
            if (app.done (start) || backTrack.tryToSolve (start))
                gui.println (SUCCESS);
            else
            {
                app.undo (start);
                gui.println (FAILURE);
            } // failure
        } // start and finish are valid
        gui.println (FINAL_STATE + app);
        gui.println (CLOSE_WINDOW_PROMPT);
        gui.freeze();

    } // method processInput

} // class MazeGUI

