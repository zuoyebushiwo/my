package com.company.target.collections.ch01;

import com.company.target.collections.general.GUI;
import com.company.target.collections.general.Process;

public class Company implements Process {

    protected final String SENTINEL_MESSAGE =
        "The sentinels are *** and -1.00.\n\n";

    protected final String INPUT_PROMPT =
        "\n\nIn the Input line, please enter a name (with no blanks) " +
        "\nand gross pay, followed by the Enter key.";

    protected Employee bestPaid;

    protected GUI gui;


    // Postcondition: The company has been initialized.
    public Company() {

        bestPaid = new Employee();
        gui = new GUI (this);
        gui.println (SENTINEL_MESSAGE);
        gui.println (INPUT_PROMPT);

    } // default constructor


    // Postcondition: The input string s has been processed.
    public void processInput (String s) {

        gui.println (s);
        Employee employee = new Employee (s);
        if (!employee.isSentinel()) {

            if (true/* replace true with missing code*/)
                //*** fill in code here;
            gui.println (INPUT_PROMPT);

        } // not the sentinel
        else
            printBestPaid();

    } // processInput


    // Postcondition: The best-paid employee in the input has been printed out.
    void printBestPaid() {

        final String BEST_PAID_MESSAGE =
            "The best paid employee (and gross pay) ";

        final String CLOSE_WINDOW_PROMPT =
            "\n\nPlease close this window when you are ready.";

        gui.println ("\n\n\n" + BEST_PAID_MESSAGE + bestPaid.printOut() +
                     CLOSE_WINDOW_PROMPT);
        gui.freeze();
        
    } // method printBestPaid


} // class Company



