package mandel.ufo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class SightingTest {

	@Test
	public void testInstantiateSighting() throws IOException {
		Sighting s = new Sighting("strange figure", "19950105", "19950305",
				"2 min", "Adjuntas, PR", "");
		Assert.assertEquals("00601", s.getZip());
	}
}
