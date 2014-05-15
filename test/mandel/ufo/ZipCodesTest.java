package mandel.ufo;

import java.io.IOException;

import org.junit.Test;

public class ZipCodesTest {

	@Test
	public void testInstantiateZipCodes() throws IOException {
		new ZipCodes("./ZIP_CODES.txt");
	}

}
