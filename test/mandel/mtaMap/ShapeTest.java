package mandel.mtaMap;

import org.junit.Assert;
import org.junit.Test;

public class ShapeTest {

	@Test
	public void testGetShapeID(){
		Shape s = new Shape("111", 1.2, 2.3);
		String id = s.getShapeID();
		String expected = "111";
		
		Assert.assertEquals(expected, id);
	}
	
}
