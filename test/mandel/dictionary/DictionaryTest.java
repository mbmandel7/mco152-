package mandel.dictionary;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testExists() throws Exception {
		Dict dictionary = new Dict();
		Assert.assertTrue(dictionary.exists("DONG"));
	}

	@Test
	public void testDoesNotExist() throws Exception {
		Dict dictionary = new Dict();
		Assert.assertFalse(dictionary.exists("jjjjjj"));
	}

	@Test
	public void testMixedCase() throws Exception {
		Dict dictionary = new Dict();
		Assert.assertTrue(dictionary.exists("Aa"));
	}
}
