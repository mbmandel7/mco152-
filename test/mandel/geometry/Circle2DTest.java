package mandel.geometry;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

	@Test
	public void testGetArea() {
		Circle2D circle = new Circle2D();
		double area = circle.getArea();
		Assert.assertEquals(Math.PI, area, .01);
	}

	@Test
	public void testGetPerimeter() {
		Circle2D circle = new Circle2D();
		double perimeter = circle.getPerimeter();
		double expectedPerimeter = Math.PI * 2;
		Assert.assertEquals(expectedPerimeter, perimeter, .01);
	}

	@Test
	public void testContainsPoint() {
		Circle2D circle = new Circle2D();
		double x = .5;
		double y = .8;
		Assert.assertTrue(circle.contains(x, y));
	}

	@Test
	public void testContainsCircle() {
		Circle2D circle = new Circle2D(3, 4, 8);
		Circle2D c = new Circle2D();
		Assert.assertTrue(circle.contains(c));
	}

	@Test
	public void testOverlaps() {
		Circle2D circle = new Circle2D(2, 0, 1.5);
		Circle2D c = new Circle2D();

		Assert.assertTrue(circle.overlaps(c));
	}
}
