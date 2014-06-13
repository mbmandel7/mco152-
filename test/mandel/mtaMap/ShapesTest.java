package mandel.mtaMap;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ShapesTest {

	@Test
	public void testGetShape() throws IOException {
		Shapes s = new Shapes();
		s.getShapes("J..N15R");
	}

	@Test
	public void testShapeIdIndex() throws IOException {
		Shapes s = new Shapes();
		s.shapeIdIndex();
	}

	@Test
	public void testGetMinLatitude() throws IOException {
		Shapes s = new Shapes();
		double actual = s.getMinLatitude();
		Assert.assertEquals(40.512764, actual, .1);
	}

	@Test
	public void testGetMaxLatitude() throws IOException {
		Shapes s = new Shapes();
		double actual = s.getMaxLatitude();
		Assert.assertEquals(40.903125, actual, .1);
	}

	@Test
	public void testGetMinLongitude() throws IOException {
		Shapes s = new Shapes();
		double actual = s.getMinLongitude();
		Assert.assertEquals(-74.251961, actual, .1);
	}

	@Test
	public void testGetMaxLongitude() throws IOException {
		Shapes s = new Shapes();
		double actual = s.getMaxLongitude();
		Assert.assertEquals(-73.755405, actual, .1);
	}

}