package com.company.target.collections.ch05;

import java.util.ArrayList;
import java.util.Collections;

/**
 * º”√‹Ω‚√‹
 */
public class VeryLongInt {

	ArrayList<Integer> digits;

	public VeryLongInt() {
		final int INITIAL_CAPACITY = 500;
		digits = new ArrayList<Integer>(INITIAL_CAPACITY);
	}

	public VeryLongInt(int n) {
		final int BASE = 10;
		digits = new ArrayList<Integer>();

		do {

			digits.add(new Integer(n % BASE));
			n = n / BASE;

		} // while
		while (n > 0);

		// digits is now in reverse order, so we reverse:
		Collections.reverse(digits);
	}

	// Postcondition: The number of elements in the VeryLongInt has
	// been returned.
	public int size() {

		return digits.size();

	} // method size

	// Precondition: The string s consists of a sequence of characters
	// with non-digit characters ignored.
	// There are no leading zeroes, except for 0
	// itself, which has a single '0'.
	// Postcondition: The VeryLongInt has been initialized from s.
	public VeryLongInt(String s) {

		final char LOWEST_DIGIT_CHAR = '0';
		final char HIGHEST_DIGIT_CHAR = '9';

		digits = new ArrayList<Integer>(s.length());
		char c;
		int digit;

		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if ((LOWEST_DIGIT_CHAR <= c) && (c <= HIGHEST_DIGIT_CHAR)) {

				digit = c - LOWEST_DIGIT_CHAR;
				digits.add(new Integer(digit));
			} // if a digit
		}
	}

	@Override
	public String toString() {
		final String EMPTY_STRING = "";

		String s = EMPTY_STRING;

		for (int i = 0; i < digits.size(); i++)
			s += digits.get(i);
		return s;
	}

	// Postcondition: If i >= digits.size(), 0 has been returned; else
	// the ith least significant digit in digits has
	// been returned. The least significant digit is
	// the 0th least significant digit.
	private int least(int i) {

		if (i >= digits.size())
			return 0;
		else
			return ((Integer) (digits.get(digits.size() - i - 1))).intValue();
	} // least

	public void add(VeryLongInt otherVeryLong) {
		final int BASE = 10;

		int largerSize, partialSum, carry = 0;

		VeryLongInt sum = new VeryLongInt();

		if (digits.size() > otherVeryLong.digits.size())
			largerSize = digits.size();
		else
			largerSize = otherVeryLong.digits.size();

		for (int i = 0; i < largerSize; i++) {

			partialSum = least(i) + otherVeryLong.least(i) + carry;
			carry = partialSum / BASE;
			sum.digits.add(new Integer(partialSum % BASE));

		} // for

		if (carry == 1)
			sum.digits.add(new Integer(carry));
		Collections.reverse(sum.digits);
		digits = sum.digits;
	} // method add

	// Postcondition: A copy of the calling object has been returned.
	@SuppressWarnings("unchecked")
	public Object clone() {

		VeryLongInt temp = new VeryLongInt();

		temp.digits = (ArrayList<Integer>) digits.clone();
		return temp;
	} // method clone

	// Postcondition: true has been returned if the
	// value of the VeryLongInt is less than the value
	// of otherVeryLong. Otherwise, false
	// has been returned.
	public boolean less(VeryLongInt otherVeryLong) {

		if (digits.size() < otherVeryLong.digits.size())
			return true;
		if (digits.size() > otherVeryLong.digits.size())
			return false;

		for (int i = 0; i < digits.size(); i++) {

			if (((Integer) (digits.get(i))).intValue() < ((Integer) (otherVeryLong.digits
					.get(i))).intValue())
				return true;
			if (((Integer) (digits.get(i))).intValue() > ((Integer) (otherVeryLong.digits
					.get(i))).intValue())
				return false;
		} // for
		return false; // the two objects have the same value
	} // method less

	// Postcondition: true has been returned if the value of the VeryLongInt
	// is greater than the value of otherVeryLong. Otherwise,
	// false has been returned.
	public boolean greater(VeryLongInt otherVeryLong) {

		return otherVeryLong.less(this);

	} // method greater

	// Postcondition: true has been returned if the value of the VeryLongInt
	// is equal to the value of otherVeryLong. Otherwise,
	// false has been returned.
	public boolean equals(VeryLongInt otherVeryLong) {

		return !less(otherVeryLong) && !otherVeryLong.less(this);

	} // method equals

	// Precondition: n > 0.
	// Postcondition: The calling object contains the nth Fibonacci
	// number.
	public void fibonacci(int n) {

		VeryLongInt previous = new VeryLongInt(1), current = new VeryLongInt(1), temp = new VeryLongInt();

		digits.clear();
		if (n <= 2)
			digits.add(new Integer(1));
		else {

			for (int i = 3; i <= n; i++) {

				temp = (VeryLongInt) current.clone();
				current.add(previous);
				previous = temp;

			} // for
			digits = current.digits;

		} // else

	} // method fibonacci

}
