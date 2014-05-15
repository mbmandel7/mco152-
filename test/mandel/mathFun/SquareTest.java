package mandel.mathFun;

import java.io.FileNotFoundException;
import mandel.mathFun.MaxSum;

import org.junit.Assert;
import org.junit.Test;

public class SquareTest {

	@Test
	public void testInstantiateSquare() throws FileNotFoundException {
		MaxSum sq = new MaxSum("numbers");
		String actual = sq.toString();
		String expected = "1 3 -8 9 \n2 5 1 -4 \n6 4 -5 3 \n-9 5 3 -4";
		Assert.assertEquals(expected, actual);
	}

//	@Test
//	public void testGetSubRectangles() throws FileNotFoundException {
//		Square sq = new Square("numbers2");
//		ArrayList<int[][]> actual = sq.getSubRectangles();
//		String actualString = actual.allSubRectToString();
//		String expectedString = "3 4";
//		Assert.assertEquals(expectedString, actualString);
//
//	}

	@Test
	public void testGetMaxSubRectangle() throws FileNotFoundException {
		MaxSum sq = new MaxSum("numbers");
		sq.getMaxSubRectangle();
		String actual = sq.maxSubRectangleToString();
		String expected = "1 3 \n2 5 \n6 4";
		Assert.assertEquals(expected, actual);
	}

}
