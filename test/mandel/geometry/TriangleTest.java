package mandel.geometry;

import mandel.geometry.Triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void testPrintTriangleWithNegativeHeight() {
		Triangle triangle = new Triangle(-4);
		String actualTriangle = triangle.toString();
		String expectedTriangle = "";
		Assert.assertEquals(expectedTriangle, actualTriangle);
	}

	@Test
	public void testTriangle0() {
		Triangle triangle = new Triangle(0);
		String actualTriangle = triangle.toString();
		String expectedTriangle = "";
		Assert.assertEquals(expectedTriangle, actualTriangle);
	}

	@Test
	public void testPrintTriangle1() {
		Triangle triangle = new Triangle(1);
		String actualTriangle = triangle.toString();
		String expectedTriangle = "*";
		Assert.assertEquals(expectedTriangle, actualTriangle);
	}

	@Test
	public void testPrintTriangle2() {
		Triangle triangle = new Triangle(2);
		String actualTriangle = triangle.toString();
		String expectedTriangle = " *\n***";
		Assert.assertEquals(expectedTriangle, actualTriangle);
	}

	@Test
	public void testPrintTriangle4() {
		Triangle triangle = new Triangle(4);
		String actualTriangle = triangle.toString();
		String expectedTriangle = "   *\n  * *\n *   *\n*******";
		Assert.assertEquals(expectedTriangle, actualTriangle);
	}

	@Test
	public void testPrintTriangle11() {
		Triangle triangle = new Triangle(11);
		String actualTriangle = triangle.toString();
		String expectedTriangle = "          *\n         * *\n        *   *\n       *     *\n      *       *\n     *         *\n    *           *\n   *             *\n  *               *\n *                 *\n*********************";
		Assert.assertEquals(expectedTriangle, actualTriangle);
	}
}
