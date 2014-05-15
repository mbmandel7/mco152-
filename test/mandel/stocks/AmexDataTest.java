package mandel.stocks;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void testDailyPrice() {
		new DailyPrice("aaa", "bbb", new Date(), 1.0, 2.0, 3.0, 4.0, 5, 6.0);
	}

	@Test
	public void testAmexData() throws IOException {
		new AmexData();
	}

	@Test
	public void testContains() throws IOException {
		AmexData data = new AmexData();
		Assert.assertTrue(data.contains("ADG"));
	}

	@Test
	public void testContainsFalse() throws IOException {
		AmexData data = new AmexData();
		Assert.assertFalse(data.contains("SSS"));
	}

	@Test
	public void testContainsBlankString() throws IOException {
		AmexData data = new AmexData();
		Assert.assertFalse(data.contains(""));
	}

	@Test
	public void testGetPrices() throws IOException {
		AmexData data = new AmexData();
		List<DailyPrice> list = data.getPrices("AIS");
		int size = 3338;
		Assert.assertEquals(size, list.size());
	}

	@Test
	public void testGetPricesWithinDateRange() throws IOException {
		AmexData data = new AmexData();
		@SuppressWarnings("deprecation")
		Date startDate = new Date(2009, 11, 1);
		@SuppressWarnings("deprecation")
		Date endDate = new Date(2009, 11, 31);
		List<DailyPrice> list = data.getPrices("AIS", startDate, endDate);
		int size = 22;
		Assert.assertEquals(size, list.size());
	}
}
