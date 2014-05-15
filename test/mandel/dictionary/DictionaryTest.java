package mandel.dictionary;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testExists() throws Exception {
		Dictionary dictionary = new Dictionary();
		Assert.assertTrue(dictionary.exists("DONG"));
	}

	@Test
	public void testDoesNotExist() throws Exception {
		Dictionary dictionary = new Dictionary();
		Assert.assertFalse(dictionary.exists("jjjjjj"));
	}

	@Test
	public void testMixedCase() throws Exception {
		Dictionary dictionary = new Dictionary();
		Assert.assertTrue(dictionary.exists("Aa"));
	}
}
