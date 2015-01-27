package com.company.target.collections.ch01;

import java.util.StringTokenizer;

import com.company.target.collections.general.GUI;
import com.company.target.collections.general.Process;

public class CompanyAll implements Process {

    protected final String SENTINEL_MESSAGE =
     "The sentinels for employee input are *** and -1.00.\n" +
     "The sentinels for hourly-employee input are ***, -1 and -1.00.";

    protected final String EMPLOYEE_PROMPT =
        "\n\nIn the Input line, please enter a name (with no blanks), " +
        "\nand gross pay, followed by the Enter key.";

    protected final String HOURLY_PROMPT =
        "\n\nIn the Input line, please enter a name (with no blanks), " +
        "\nhours worked and pay rate, followed by the Enter key.";

    protected final String GENERIC_PROMPT = "\nFor employee input:" +
        EMPLOYEE_PROMPT + "\n\nFor hourly-employee input:" + HOURLY_PROMPT;

    protected Employee bestPaid;

    protected GUI gui;

    protected boolean atLeastOneEmployee;


    // Postcondition: this CompanyAll object has been initialized.
    public CompanyAll() {

        bestPaid = new Employee();
        atLeastOneEmployee = false;
        gui = new GUI(this);
        gui.println (SENTINEL_MESSAGE);
        gui.println (GENERIC_PROMPT);

    } // default constructor


    // Postcondition: The input string s -- consisting of either an employee
    //                or an hourly employee -- has been processed against
    //                what had been this company's best-paid employee.
    public void processInput (String s) {

        final String ERROR =
            "\nError: the input is incorrect.\n";

        Employee employee;

        String prompt;

        gui.println (s);
        int count = new StringTokenizer (s).countTokens();
        if (count !=2 && count != 3)
            gui.println (ERROR + GENERIC_PROMPT);
        else {

            if (count == 2) { // 2 input fields for an employee

                employee = new Employee (s);
                prompt = EMPLOYEE_PROMPT;

            } // employee input
            else { // 3 input fields for an hourly employee

                employee = new HourlyEmployee (s);
                prompt = HOURLY_PROMPT;

            } // hourly-employee input
            if (!employee.isSentinel()) {

                atLeastOneEmployee = true;
                if (employee.makesMoreThan (bestPaid))
                    bestPaid = employee;
                gui.println (prompt);

            } // not the sentinel
            else
                printBestPaid();
        } // 2 or 3 tokens

    } // processInput


     // Postcondition: this CompanyAll object's best-paid employee
     //                has been printed out.
    protected void printBestPaid() {

        final String NO_INPUT_MESSAGE =
            "\n\n\nError: there were no employees in the input.";

        final String BEST_PAID_MESSAGE =
            "The best paid employee (and gross pay) is ";

        final String CLOSE_WINDOW_PROMPT =
            "\n\nPlease close this window when you are ready.";

        if (atLeastOneEmployee)
            gui.println ("\n\n\n" + BEST_PAID_MESSAGE + bestPaid);
        else
            gui.println (NO_INPUT_MESSAGE);
        gui.println (CLOSE_WINDOW_PROMPT);
        gui.freeze();

    } // method printBestPaid


} // class CompanyAll



