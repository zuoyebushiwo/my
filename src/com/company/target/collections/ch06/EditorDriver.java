package com.company.target.collections.ch06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.company.target.collections.general.GUI;

public class EditorDriver implements
		com.company.target.collections.general.Process {

	public final static String CLOSE_WINDOW_PROMPT = "The editing is done.  Please close this window when you are ready.";

	public final static String IN_FILE_PROMPT = "In the Input line, please enter the path for the input file.";

	public final static String OUT_FILE_PROMPT = "In the Input line, please enter the path for the output file.";

	protected GUI gui;

	protected Editor editor;

	protected BufferedReader fileReader;

	protected PrintWriter fileWriter;

	protected boolean readingInputPath, inputFileFound;

	// Postcondition: this driver has been initialized.
	public EditorDriver() {
		gui = new GUI(this);
		readingInputPath = true;
		inputFileFound = false;
		editor = new Editor();
		gui.println(IN_FILE_PROMPT);
	}

	// Postcondition: s, representing an input file path or an output file
	// path, has been used to set up a file reader or writer.
	// If a file writer, then the input file has been processed.
	@Override
	public void processInput(String s) {
		final String FILE_NOT_FOUND_MESSAGE = "The file was not found.\n\n";

		final String IO_EXCEPTION_MESSAGE = "There was an IO exception.";

		try {

			gui.println(s);
			if (readingInputPath) {

				if (!inputFileFound) {

					fileReader = new BufferedReader(new FileReader(s));
					inputFileFound = true;
					readingInputPath = false;
					gui.println(OUT_FILE_PROMPT);

				} // input file not yet found

			} // input-path line
			else {

				fileWriter = new PrintWriter(new FileWriter(s));
				readAndProcessInFile();
				gui.println(CLOSE_WINDOW_PROMPT);
				gui.freeze();

			} // output-path line

		} // try
		catch (FileNotFoundException e) {

			gui.println(FILE_NOT_FOUND_MESSAGE + IN_FILE_PROMPT);

		} // catch FileNotFoundException
		catch (IOException e) {

			gui.println(IO_EXCEPTION_MESSAGE + e);

		} // catch I/O exception
	}

	// Postcondition: All of the commands in the input file have been read in
	// and processed.
	protected void readAndProcessInFile() throws IOException {

		final String LINE_PROMPT = "\nPlease enter a line; a command must start with a "
				+ Editor.COMMAND_START + ".";

		String result = new String();

		fileWriter.println(LINE_PROMPT);
		String line = fileReader.readLine();
		while (line != null) {

			try {

				fileWriter.println(line);
				result = editor.interpret(line);

			} // try
			catch (RuntimeException e) {

				fileWriter.println(e);

			} // catch
			if (line.equals(Editor.DONE_COMMAND))
				fileWriter.println(result);
			else
				fileWriter.println(LINE_PROMPT);
			line = fileReader.readLine();
		} // while
		fileWriter.close();

	} // method readAndProcessInFile

}
