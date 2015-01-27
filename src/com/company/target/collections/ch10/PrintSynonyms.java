package com.company.target.collections.ch10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.company.target.collections.general.GUI;

/**
 * ¥Ú”°Õ¨“Â¥ 
 */
public class PrintSynonyms implements
		com.company.target.collections.general.Process {

	protected final String INPUT_PROMPT = "\nPlease enter a word; the sentinel is ";

	protected final String SENTINEL = "***\n";

	GUI gui;

	BufferedReader thesaurusFile;
	TreeMap<Object, LinkedList<Object>> thesaurusMap;

	// Postcondition: The synonym printer has been initialized.
	public PrintSynonyms() {
		final String FILE_NAME = "thesaurus.txt";

		final String THESAURUS_MESSAGE = "Here are the contents of the thesaurus file:\n";

		final String ERROR_MESSAGE = "Exception:";

		try {
			gui = new GUI(this);
			BufferedReader fileReader = new BufferedReader(new FileReader(
					FILE_NAME));

			thesaurusMap = new TreeMap<Object, LinkedList<Object>>();
			String line;
			while ((line = fileReader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				LinkedList<Object> synonymList = new LinkedList<Object>();

				String word = st.nextToken();
				while (st.hasMoreTokens()) {
					synonymList.add(st.nextToken());
				}
				thesaurusMap.put(word, synonymList);

				gui.println(THESAURUS_MESSAGE + thesaurusMap);
				gui.println(INPUT_PROMPT + SENTINEL);
			}

		} catch (IOException e) {
			gui.println(ERROR_MESSAGE + e);
		}
	}

	@Override
	public void processInput(String s) {
		final String WORD_NOT_FOUND_MESSAGE = "The word is not in the thesaurus.\n";

		final String CLOSE_WINDOW_MESSAGE = "\n\nThe execution the project is complete.  Please close "
				+ "the window when you are ready.";

		LinkedList<Object> synonymList = new LinkedList<Object>();

		if (!s.equals(SENTINEL)) {

			synonymList = thesaurusMap.get(s);
			if (synonymList == null)
				gui.print(WORD_NOT_FOUND_MESSAGE);
			else {

				Iterator<Object> itr = synonymList.iterator();
				while (itr.hasNext())
					gui.print(itr.next().toString());

				gui.print(INPUT_PROMPT + SENTINEL);

			} // word is in thesaurus

		} // not the sentinel
		else
			gui.print(CLOSE_WINDOW_MESSAGE);
	}

}
