package mandel.dictionary;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Iterator;

public class StatisticsOfOWL {

	public static void main(String args[]) throws FileNotFoundException {
		Dictionary dict = new Dictionary();
		System.out.println(getAlphabetData(dict.iterator()));
	}

	public static double getNumOccurences(Iterator<String> words, char letter) {
		int numOccurences = 0;
		while (words.hasNext()) {
			String s = words.next();
			for (int i = 0; i < s.length(); i++) {
				if (letter == s.charAt(i)) {
					numOccurences++;
				}
			}
		}
		return numOccurences;
	}

	public static double getPercentage(Iterator<String> words, char letter) {
		double numOccurences = getNumOccurences(words, letter);
		double numWords = getNumWords(words);
		return numOccurences / numWords;
	}

	public static double getNumWords(Iterator<String> words) {
		int numWords = 0;
		while (words.hasNext()) {
			numWords++;
		}
		return numWords;
	}

	public static String getOneLetterData(Iterator<String> words, char letter) {
		DecimalFormat formatter = new DecimalFormat("#0.00%");
		return letter + "  " + getNumOccurences(words, letter) + "\t"
				+ formatter.format(getPercentage(words, letter));
	}

	public static String getAlphabetData(Iterator<String> words) {
		StringBuffer alphabetData = new StringBuffer();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < alphabet.length(); i++) {
			char l = alphabet.charAt(i);
			char letter = (char) (l + 32);
			alphabetData.append(getOneLetterData(words, letter));
			alphabetData.append("\n");
		}
		return alphabetData.toString();
	}
}
