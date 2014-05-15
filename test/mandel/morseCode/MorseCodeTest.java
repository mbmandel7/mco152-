package mandel.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	// annotation. needed for tests
	@Test
	public void testAlphabetToMorseCode() {
		MorseCode morseCode = new MorseCode();
		String alphabet = "ABC   ";
		String code = morseCode.toMorseCode(alphabet);
		String expectedOutput = ".- -... -.-.";

		Assert.assertEquals(expectedOutput, code);
	}

	@Test
	public void testMorseCodeToAlphabet() {
		MorseCode morseCode = new MorseCode();
		String alphabet = morseCode
				.toPlainText("- .... . / .-. . -.. / -.. --- --.");
		String expectedOutput = "THE RED DOG";

		Assert.assertEquals(expectedOutput, alphabet);
	}

	//
	// @Test
	// public void testNullStringToMorse(){
	// MorseCode morseCode = new MorseCode();
	// String alphabet = null;
	// String code = morseCode.toMorseCode(alphabet);
	//
	// Assert.assertEquals(code, alphabet);
	// // }
	//
	// @Test
	// public void testNullStringToText(){
	// MorseCode morseCode = new MorseCode();
	// String morse = null;
	// String expectedOutput = morseCode.toPlainText(morse);
	//
	// Assert.assertEquals(expectedOutput, morse);
	// }

	@Test
	public void testBlankStringToMorse() {
		MorseCode morseCode = new MorseCode();
		String blankTxt = "";
		String morse = morseCode.toMorseCode(blankTxt);

		Assert.assertEquals(morse, blankTxt);
	}

	@Test
	public void testBlankStringToText() {
		MorseCode morseCode = new MorseCode();
		String morse = "";
		String text = morseCode.toPlainText(morse);

		Assert.assertEquals(text, morse);
	}

	@Test
	public void testNotSameToMorse() {
		MorseCode morseCode = new MorseCode();
		String text = "happy and you know it";
		String morse = morseCode.toMorseCode("and we know");

		Assert.assertNotSame(text, morse);
	}
}
