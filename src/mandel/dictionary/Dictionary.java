package mandel.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	private Map<String, String> words;

	public Dictionary() throws FileNotFoundException {
		words = new HashMap<String, String>();
		Scanner in = new Scanner(new File("./OWL.txt"));
		while (in.hasNext()) {
			String word = in.next();
			String definition = in.nextLine();
			words.put(word, definition);
		}
		in.close();
	}

	public Iterator<String> iterator() {
		return words.keySet().iterator();
	}

	public boolean exists(String newWord) {
		return words.containsKey(newWord.toUpperCase());
	}

	public String getDefinition(String word) {
		return words.get(word.toUpperCase());
	}
}