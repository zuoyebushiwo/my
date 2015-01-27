package com.company.target.collections.ch08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.company.target.collections.general.GUI;
import com.company.target.collections.general.Process;

public class BinSearchTreeDriver implements Process {

	protected final String IN_FILE_PROMPT = "In the Input line, please enter the path for the input file.";

	protected final String OUT_FILE_PROMPT = "In the Input line, please enter the path for the output file.";

	protected GUI gui;

	protected BinSearchTree myTree;

	protected Iterator itr;

	protected BufferedReader fileReader;

	protected PrintWriter fileWriter;

	protected int lineRead;

	// Postcondition: this BinSearchTreeDriver object has been initialized.
	public BinSearchTreeDriver() {

		lineRead = 0;
		gui = new GUI(this);
		gui.println(IN_FILE_PROMPT);

	} // default constructor

	// Postcondition: One line of input (containing either the input-file
	// path or the output-file path) has been processed.
	public void processInput(String s) {

		final String FILE_NOT_FOUND_MESSAGE = "The file was not found.";

		final String IO_EXCEPTION_MESSAGE = "There was an IO exception.";

		try {

			gui.println(s);
			if (lineRead == 0) {

				fileReader = new BufferedReader(new FileReader(s));
				lineRead++;
				gui.println(OUT_FILE_PROMPT);

			} // input-path line
			else if (lineRead == 1) {

				fileWriter = new PrintWriter(new FileWriter(s));
				readAndProcessInFile();

			} // output-path line

		} // try
		catch (FileNotFoundException e) {

			gui.print(FILE_NOT_FOUND_MESSAGE);

		} // catch FileNotFoundException
		catch (IOException e) {

			gui.print(IO_EXCEPTION_MESSAGE + e);

		} // catch IOException

	} // method processInput

	// Postcondition: All of the method calls in the input file have been
	// read in and processed.
	public void readAndProcessInFile() throws IOException {

		final String TREE_MESSAGE = "Here is the BinSearchTree:\n";

		final String LINE_MESSAGE = "The line is:\n";

		final String CLOSE_WINDOW_PROMPT = "\nThe execution of this project  "
				+ "has been completed. Please close this window when you are ready.";

		Iterator tempItr;

		String line = fileReader.readLine();

		while (line != null) {

			fileWriter.println(LINE_MESSAGE + line);
			callMethod(line);
			fileWriter.print(TREE_MESSAGE);
			tempItr = myTree.iterator();
			while (tempItr.hasNext())
				fileWriter.println(tempItr.next());
			fileWriter.println("\n\n\n");
			line = fileReader.readLine();

		} // while line != null
		fileWriter.close();
		gui.println(CLOSE_WINDOW_PROMPT);
		gui.freeze();

	} // method readAndProcess

	// Postcondition: The method in line has been processed.
	void callMethod(String line) throws IOException {

		final String CONSTRUCTOR = "BinSearchTree";

		final String CONSTRUCTOR_MESSAGE = "This BinSearchTree object has been constructed.";

		final String SIZE = "size";

		final String SIZE_MESSAGE = "The size of this BinSearchTree object is ";

		final String IS_EMPTY = "isEmpty";

		final String IS_EMPTY_MESSAGE = "This BinSearchTree object is empty? ";

		final String ITERATOR = "iterator";

		final String ITERATOR_MESSAGE = "This iterator has been constructed.";

		final String CONTAINS = "contains";

		final String CONTAINS_MESSAGE = " is contained in this BinSearchTree object? ";

		final String ADD = "add";

		final String ADD_MESSAGE = " has been inserted into this BinSearchTree object? ";

		final String REMOVE = "remove";

		final String REMOVE_MESSAGE = " has been removed from this BinSearchTree object? ";

		final String HAS_NEXT = "hasNext";

		final String HAS_NEXT_MESSAGE = "This iterator is not positioned beyond the end of "
				+ "the BinSearchTree object? ";

		final String NEXT = "next";

		final String NEXT_MESSAGE = "The element returned by this iterator's next method is ";

		final String ITR_REMOVE_MESSAGE = "The element last returned by this iterator has been "
				+ "removed from the BinSearchTree object.";

		StringTokenizer tokens = new StringTokenizer(line);
		String method = tokens.nextToken();
		Integer element;

		try {

			if (method.equals(CONSTRUCTOR)) {

				myTree = new BinSearchTree();
				fileWriter.println(CONSTRUCTOR_MESSAGE);

			} // constructor
			else if (method.equals(SIZE))
				fileWriter.println(SIZE_MESSAGE + myTree.size());
			else if (method.equals(IS_EMPTY))
				fileWriter.println(IS_EMPTY_MESSAGE + myTree.isEmpty());
			else if (method.equals(ITERATOR)) {

				itr = myTree.iterator();
				fileWriter.println(ITERATOR_MESSAGE);

			} // iterator method
			else if (method.equals(CONTAINS)) {

				element = new Integer(tokens.nextToken());
				fileWriter.println(element + CONTAINS_MESSAGE
						+ myTree.contains(element));

			} // contains method
			else if (method.equals(ADD)) {

				element = new Integer(tokens.nextToken());
				fileWriter.println(element + ADD_MESSAGE + myTree.add(element));

			} // method add
			else if (method.equals(REMOVE)) {

				if (tokens.hasMoreTokens()) {

					element = new Integer(tokens.nextToken());
					fileWriter.println(element + REMOVE_MESSAGE
							+ myTree.remove(element));

				} // method remove in BinSearchTree class
				else {

					itr.remove();
					fileWriter.println(ITR_REMOVE_MESSAGE);

				} // method remove in itr's class
			} // a remove method
			else if (method.equals(HAS_NEXT))
				fileWriter.println(HAS_NEXT_MESSAGE + itr.hasNext());
			else if (method.equals(NEXT))
				fileWriter.println(NEXT_MESSAGE + (Integer) itr.next());

		} // try
		catch (NoSuchElementException e) {

			final String MISSING_ELEMENT_MESSAGE = "An element should have been supplied for this method call.";

			fileWriter.println(e + MISSING_ELEMENT_MESSAGE);

		} // catch NoSuchElementException
		catch (NumberFormatException e) {

			final String INTEGER_NEEDED_MESSAGE = "The element should be an integer.";

			fileWriter.println(e + INTEGER_NEEDED_MESSAGE);

		} // catch NumberFormatException

	} // method callMethod

} // class BinSearchTreeDriver

