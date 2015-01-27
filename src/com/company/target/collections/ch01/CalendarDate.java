package com.company.target.collections.ch01;

public class CalendarDate {

    final static int MONTHS_IN_YEAR = 12,
                     DAYS_IN_WEEK = 7,
                     MIN_YEAR = 1800,
                     MAX_YEAR = 2200,
                     MIN_FIRST_DAY = 3; // first day of 1/1/1800 was Wednesday

    int day, month, year;


    // Postcondition: this CalendarDate has been initialized from year,
    //                month and day.
    public CalendarDate(int yearIn, int monthIn, int dayIn) {

        day = dayIn;
        month = monthIn;
        year = yearIn;
    } // constructor


    // Postcondition: true has been returned if this CalendarDate is
    //                a legal date. Otherwise, false has been returned
    public boolean isValid( ) {

	      if (month < 1 || month > MONTHS_IN_YEAR || day < 1 || year < MIN_YEAR ||
                         year > MAX_YEAR)
	          return false;
	      return day <= daysInMonth (month, year);

    }  // method isValid


    // Postcondition: the number of days in monthIn of yearIn has been
    //                returned.
    private int daysInMonth(int monthIn, int yearIn) {

        if (monthIn == 4 || monthIn == 6 || monthIn == 9 || monthIn == 11)
 	          return 30;   // 30 days hath September, April, June and November

        if (monthIn == 1 || monthIn == 3 || monthIn == 5 || monthIn == 7 ||
		             monthIn  == 8 || monthIn == 10 || monthIn == 12)
            return 31; // January, March, May, July, August, October, December

	      if (yearIn % 4 != 0 || (yearIn % 100 == 0 && yearIn % 400 != 0))
	          return  28; // one year is slightly less than 365.25 days

	      return 29;

    } // method daysInMonth


    // Precondition: this CalendarDate is valid.
    // Postcondition: the date after this CalendarDate has been returned.
    public CalendarDate next() {

        if (day < daysInMonth (month, year))
            return new CalendarDate (year, month, day + 1);
        if (day == daysInMonth (month, year) && month != MONTHS_IN_YEAR)
            return new CalendarDate (year, month + 1, 1);
        return new CalendarDate (year + 1, 1, 1);

    } // method next


    // Precondition: this CalendarDate is valid.
    // Postcondition: the date just before this CalendarDate has been
    //                returned.
    public CalendarDate previous() {

        if (day > 1)
            return new CalendarDate(year, month, day - 1);
        if (day == 1 && month != 1)
            return new CalendarDate(year, month - 1, daysInMonth(month - 1, year));
        // day == 1 && month == 1
        return new CalendarDate(year - 1, MONTHS_IN_YEAR, 31);

    } // method previous


    // Precondition: this CalendarDate is valid.
    // Poscondition: the number of days left in this year has been returned.
    public int daysLeftInYear() {

        int daysLeft = daysInMonth (month, year) - day, //was dayOfMonth
                       i = month + 1;

        while (i <= MONTHS_IN_YEAR) {

            daysLeft += daysInMonth (i, year);
            i++;

        } // while
        return daysLeft;

    } // method daysLeftInYear


    // Precondition: this CalendarDate is valid.
    // Postcondition: the first day of this CalendarDate has been returned.
    public int firstDay() {

        // Because 365 % 7 = 1, if a non-leap year starts on a certain day of
        // the week, the next year will start on the next day of the week.
        // For example, January 1 of 1998 fell on a Thursday, so January 1 of
        // 1999 fell on a Friday.

        // For a leap year, the next year will start two days-of-the-week later.
        // For example, January 1 of 2000 fell on a Saturday, so January 1 of
        // 2001 fell on a Monday.

        // Start with the first day of MIN_YEAR.  For each year, add 1, then
        // add 1 for every year after a fourth year. Then subtract 1 for each
        // fourth year that is not a leap year, that is, each century year
        // that is less than year but is not a leap year.

        int temp = MIN_FIRST_DAY + (year - MIN_YEAR) + (year - 1 - MIN_YEAR) / 4;

        for (int i = MIN_YEAR + 100; i < year; i = i + 100)
            if (!isLeapYear (i))
                temp--;

        return temp % DAYS_IN_WEEK;

    } // method firstDay


    // Precondition: this CalendarDate is valid.
    // Postcondition: the number of the day of the week on which this
    //                CalendarDate falls has been returned.
    private int thisDayOfWeek() {

        // Take days from Jan 1 to this day, add day of week for Jan 1, % 7.

        if (isLeapYear (year))
            return (365 - daysLeftInYear() + firstDay()) % DAYS_IN_WEEK;
        return (364 - daysLeftInYear() + firstDay()) % DAYS_IN_WEEK;

    } // method thisDayOfWeek


    // Precondition: this CalendarDate is valid.
    // Postcondition: the name of the day of the week on which this
    //                CalendarDate falls has been returned.
    public String dayName() {

        int this_day;
        String day_names[] = { "Sunday", "Monday", "Tuesday", "Wednesday",
                               "Thursday", "Friday", "Saturday" };

        // Take days from Jan 1 to this day, add day of week for Jan 1, % 7.
        if (isLeapYear (year))
            this_day = (365 - daysLeftInYear() + firstDay()) % DAYS_IN_WEEK;
        else
            this_day = (364 - daysLeftInYear() + firstDay()) % DAYS_IN_WEEK;
        return day_names [this_day];

    } // method dayOfWeek


    // Precondition: yearIn is a valid year.
    // Postcondition: true has been returned if yearIn is a leap year.
    //                Otherwise, false has been returned.
    private boolean isLeapYear (int yearIn) {

        if (yearIn % 4 == 0 && (yearIn % 100 != 0 || yearIn % 400 == 0))
            return true;
        return false;

    } // method isLeapYear


    String monthName() {

        String monthNames[] = { "January", "February", "March", "April",
                                 "May", "June", "July", "August", "September",
                                 "October", "November", "December" };

        return monthNames [month - 1];

    } // method month_name


    // Precondition: this CalendarDate is valid.
    // Postcondition: true has been returned if this CalendarDate is prior
    //                to otherDate.  Otherwise, false has been returned.
    public boolean isPriorTo(CalendarDate otherDate) {

       if (year > otherDate.year)
           return false;
       if (year < otherDate.year )
           return true;

       if (month < otherDate.year)
           return true;
       if (month > otherDate.year)
           return false;

       if (day < otherDate.day)
           return true;
       return false;

    } // method isPriorTo


    // Precondition: this CalendarDate is valid.
    // Postcondition: a String representation of this CalendarDate
    //                has been returned.
    public String toString() {

        return monthName() + " " + day + ", " + year;

    } // method toString

} // class CalendarDate

