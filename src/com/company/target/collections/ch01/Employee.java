package com.company.target.collections.ch01;

import java.util.*;

class Employee {

    protected final static String EMPTY_STRING = "";

    protected final static String NAME_SENTINEL = "***";

    protected final static double GROSS_PAY_SENTINEL = -1.00;

    protected String name;

    protected double grossPay;


    // Postcondition: The employee has been initialized: the name is an
    //                empty string and the gross pay is 0.00.
    public Employee(){

        name = EMPTY_STRING;
    }


    // Postcondition: The employee has been initialized from the String
    //                s, which consists of a name and gross pay.
    public Employee (String s) {

        StringTokenizer tokens = new StringTokenizer (s);
        name = tokens.nextToken();
        grossPay = Double.valueOf (tokens.nextToken()).doubleValue();

    } // constructor


    // Postcondition: true has been returned if the employee is the sentinel.
    //                Otherwise, false has been returned.
    public boolean isSentinel() {

        if (name.equals (NAME_SENTINEL) && grossPay == GROSS_PAY_SENTINEL)
            return true;
        return false;

    } // method isSentinel


    // Postcondition: If the employee's gross pay is larger than otherEmployee's
    //                gross pay, true has been returned.  Otherwise, false has
    //                been returned.
    public boolean makesMoreThan (Employee otherEmployee) {


        return grossPay > otherEmployee.grossPay;

    } // method makesMoreThan


    // Postcondition: a String representation of the employee's name and
    //                gross pay have been returned.
    public String toString() {

        final String DOLLAR_SIGN = "   $";

        return (name + DOLLAR_SIGN + grossPay);

    } // method printOut()


	public String printOut() {
		// TODO Auto-generated method stub
		return null;
	}


} // class Employee

