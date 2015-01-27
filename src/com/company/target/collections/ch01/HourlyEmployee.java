package com.company.target.collections.ch01;

import java.util.*;

class HourlyEmployee extends Employee {

    protected static final int HOURS_WORKED_SENTINEL = -1;

    protected static final double PAY_RATE_SENTINEL = -1.00;

    protected int hoursWorked;

    protected double payRate;


    // Postcondition: this HourlyEmployee object has been initialized.
    HourlyEmployee() {}


    // Postcondition: this HourlyEmployee object has been initialized from s.
    HourlyEmployee (String s)
    {
            StringTokenizer tokens = new StringTokenizer (s);
            name = tokens.nextToken();
            hoursWorked = Integer.parseInt (tokens.nextToken());
            payRate = Double.parseDouble (tokens.nextToken());

            grossPay = hoursWorked * payRate;

    } // constructor


    // Postcondition: true has been returned if the employee is the sentinel.
    //                Otherwise, false has been returned.
    public boolean isSentinel() {

        if (name.equals (NAME_SENTINEL) && hoursWorked == HOURS_WORKED_SENTINEL
                && payRate == PAY_RATE_SENTINEL)
            return true;
        return false;

    } // method isSentinel


} // class HourlyEmployee

