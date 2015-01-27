package com.company.target.collections.ch06;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * 文本编辑器
 */
public class Editor {

	public final static char COMMAND_START = '$';

	public final static String INSERT_COMMAND = "$Insert";

	public final static String DELETE_COMMAND = "$Delete";

	public final static String LINE_COMMAND = "$Line";

	public final static String DONE_COMMAND = "$Done";

	public final static String BAD_LINE_MESSAGE = "Error: a command should start with "
			+ COMMAND_START + ".\n";

	public final static String BAD_COMMAND_MESSAGE = "Error: not one of the given commands.\n";

	public final static String INTEGER_NEEDED = "\nError: The command should be followed by a blank space, "
			+ "followed by an integer.\n";

	public final static String TWO_INTEGERS_NEEDED = "\nError: The command should be followed by a blank space, "
			+ "followed by an integer,\nfollowed by a blank space, "
			+ "followed by an integer.\n";

	public final static String FIRST_GREATER = "Error: the first line number given is greater than the second.\n";

	public final static String FIRST_LESS_THAN_ZERO = "Error: the first line number given is less than 0.\n";

	public final static String SECOND_TOO_LARGE = "Error: the second line number given is greater than the "
			+ "number of the last line in the text.\n";

	public final static String M_LESS_THAN_ZERO = "Error: the number is less than 0.\n";

	public final static String M_TOO_LARGE = "Error: the number is larger than the number of lines in the text.\n";

	public final static String LINE_TOO_LONG = "Error: the line exceeds the maximum number of characters allowed, ";

	public final static int MAX_LINE_LENGTH = 75;

	protected LinkedList<String> text;

	protected ListIterator<String> current;

	protected boolean inserting;

	/**
	 * 默认文本编辑器构造方法
	 */
	public Editor() {
		text = new LinkedList<String>();
		current = text.listIterator();
		inserting = false;
	}

	// Postcondition: the line s has been interpreted, and the
	// result of carrying out (if a command) or
	// inserting that line has been returned.
	public String interpret(String s) {

		StringTokenizer tokens = new StringTokenizer(s);
		String command;

		if (s.charAt(0) != COMMAND_START) {
			if (inserting) {
				insert(s);
			} else {
				throw new RuntimeException(BAD_LINE_MESSAGE);
			}
		} else {
			command = tokens.nextToken();
			if (command.equals(INSERT_COMMAND)) {
				inserting = true;
			} else {
				inserting = false;
				if (command.equals(DELETE_COMMAND)) {
					tryToDelete(tokens);
				} else if (command.equals(LINE_COMMAND)) {
					tryToSetLine(tokens);
				} else if (command.equals(DONE_COMMAND)) {
					return done();
				} else {
					throw new RuntimeException(BAD_COMMAND_MESSAGE);
				}
			}
		}
		return null;
	}

	// Precondition: tokens has two more tokens, and they represent legal
	// line numbers for a deletion. Otherwise, a
	// RuntimeException has been thrown.
	// Postcondition: the current delete command has been carried out.
	protected void tryToDelete(StringTokenizer tokens) {
		try {
			int m = Integer.parseInt(tokens.nextToken());
			int n = Integer.parseInt(tokens.nextToken());
			delete(m, n);
		} catch (NoSuchElementException e1) {
			throw new RuntimeException(e1 + TWO_INTEGERS_NEEDED);
		} catch (NumberFormatException e2) {
			throw new RuntimeException(e2 + TWO_INTEGERS_NEEDED);
		} // input not integers
	}

	// Precondition: tokens has one more token, and that represents a legal
	// number for the $Line command. Otherwise, a
	// RuntimeException has been thrown.
	// Postcondition: the $Line command has been carried out.
	protected void tryToSetLine(StringTokenizer tokens) {
		try {
			int m = Integer.parseInt(tokens.nextToken());
			line(m);
		} catch (NoSuchElementException e1) {

			throw new RuntimeException(e1 + INTEGER_NEEDED);

		} // no next token
		catch (NumberFormatException e2) {
			throw new RuntimeException(e2 + INTEGER_NEEDED);
		} // next token not an integer
	}

	// Precondition: the length of s is at most MAX_LINE_LENGTH characters.
	// Otherwise, a RuntimeException has been thrown.
	// Postcondition: s has been inserted into the editor in front of the
	// curren
	public void insert(String s) {
		if (s.length() > MAX_LINE_LENGTH) {
			throw new RuntimeException(LINE_TOO_LONG + MAX_LINE_LENGTH + "\n");
		}
		current.add(s);
	}

	// Precondition: 0 <= m <= n < the number of lines in the text.
	// Otherwise, a RuntimeException has been thrown.
	// Postcondition: lines m through n have been removed from the text.
	public void delete(int m, int n) {
		if (m > n)
			throw new RuntimeException(FIRST_GREATER);
		if (m < 0)
			throw new RuntimeException(FIRST_LESS_THAN_ZERO);
		if (n >= text.size())
			throw new RuntimeException(SECOND_TOO_LARGE);

		current = text.listIterator(m);
		for (int i = m; i <= n; i++) {
			current.next();
			current.remove();
		}
	}

	// Precondition: 0 <= m <= the number of lines of text. Otherwise, a
	// RuntimeException has been thrown.
	// Postcondition: the current line in the text has been set to m.
	public void line(int m) {

		if (m < 0)
			throw new RuntimeException(M_LESS_THAN_ZERO);
		if (m > text.size())
			throw new RuntimeException(M_TOO_LARGE);
		current = text.listIterator(m);

	} // method line

	// Postcondition: the editing is complete and the text has been returned.
	public String done() {
		final String FINAL_TEXT_MESSAGE = "\n\nHere is the final text:\n";
		String s = FINAL_TEXT_MESSAGE;

		ListIterator<String> itr = text.listIterator();

		while (itr.hasNext())
			if (itr.nextIndex() == current.nextIndex())
				s = s + ">  " + itr.next() + '\n';
			else
				s = s + "   " + itr.next() + '\n';
		if (!current.hasNext())
			s = s + ">   " + '\n';
		return s;
	}

}
