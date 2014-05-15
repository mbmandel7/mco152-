package mandel.morseCode;

import java.util.HashMap;

public class MorseCode {

	private HashMap<Character, String> charToCode;
	private HashMap<String, Character> codeToChar;

	public MorseCode() {
		charToCode = new HashMap<Character, String>();// key is text
		codeToChar = new HashMap<String, Character>();// key is morsecode
		add("A", ".-");
		add("B", "-...");
		add("C", "-.-.");
		add("D", "-..");
		add("E", ".");
		add("F", "..-.");
		add("G", "--.");
		add("H", "....");
		add("I", "..");
		add("J", ".---");
		add("K", "-.-");
		add("L", ".-..");
		add("M", "--");
		add("N", "-.");
		add("O", "---");
		add("P", ".--.");
		add("Q", "--.-");
		add("R", ".-.");
		add("S", "...");
		add("T", "-");
		add("U", "..-");
		add("V", "...-");
		add("W", ".--");
		add("X", "-..-");
		add("Y", "-.--");
		add("Z", "--..");
		add("0", "-----");
		add("1", ".----");
		add("2", "..---");
		add("3", "...--");
		add("4", "....-");
		add("5", ".....");
		add("6", "-....");
		add("7", "--...");
		add("8", "---..");
		add("9", "----.");
		add(".", ".-.-.-");
		add(",", "--..--");
		add("?", "..--..");
		add("=", "-...-");
		add(" ", "/");
	}

	public void add(String s1, String s2) {
		charToCode.put(s1.charAt(0), s2);
		codeToChar.put(s2, s1.charAt(0));
	}

	public String toPlainText(String morseMessage) {
		StringBuilder text = new StringBuilder();
		StringBuilder morseLetter = new StringBuilder();
		for (int i = 0; i < morseMessage.trim().length(); i++) {
			morseLetter.append(morseMessage.charAt(i));
			if (morseMessage.charAt(i) == ' ') {
				text.append(codeToChar.get(morseLetter.toString()));
				morseLetter = new StringBuilder();
			}
		}

		return text.toString();
	}

	public String toMorseCode(String textMessage) {
		StringBuilder morse = new StringBuilder();
		for (int i = 0; i < textMessage.trim().length(); i++) {
			morse.append(charToCode.get(textMessage.charAt(i)));
			morse.append(" ");
		}
		return morse.toString().trim();
	}

}
