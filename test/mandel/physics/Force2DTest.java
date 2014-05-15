package mandel.physics;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void testGetPositiveX() {
		Force2D force = new Force2D(8, 13);
		double expectedX = 8.0;
		double actualX = force.getX();

		Assert.assertEquals(expectedX, actualX, .01);
	}

	@Test
	public void testGetNegativeX() {
		Force2D force = new Force2D(-4, 9);
		double expectedX = -4.0;
		double actualX = force.getX();

		Assert.assertEquals(expectedX, actualX, .01);
	}

	@Test
	public void testGetZeroX() {
		Force2D force = new Force2D(0, 4);
		double expectedX = 0.0;
		double actualX = force.getX();

		Assert.assertEquals(expectedX, actualX, .01);
	}

	@Test
	public void testGetPositiveY() {
		Force2D force = new Force2D(8, 13);
		double expectedY = 13.0;
		double actualY = force.getY();

		Assert.assertEquals(expectedY, actualY, .01);
	}

	@Test
	public void testGetNegativeY() {
		Force2D force = new Force2D(4, -9);
		double expectedY = -9.0;
		double actualY = force.getY();

		Assert.assertEquals(expectedY, actualY, .01);
	}

	@Test
	public void testGetZeroY() {
		Force2D force = new Force2D(-12, 0);
		double expectedY = 0.0;
		double actualY = force.getY();

		Assert.assertEquals(expectedY, actualY, .01);
	}

	@Test
	public void testGetIntMagnitude() {
		Force2D force = new Force2D(0, 4);
		double expectedMagnitude = 4.0;
		double actualMagnitude = force.getMagnitude();

		Assert.assertEquals(expectedMagnitude, actualMagnitude, .01);
	}

	@Test
	public void testGetMagnitude() {
		Force2D force = new Force2D(1, 2);
		double expectedMagnitude = 2.23606797749979;
		double actualMagnitude = force.getMagnitude();

		Assert.assertEquals(expectedMagnitude, actualMagnitude, .01);
	}

	@Test
	public void testGetLargerMagnitude() {
		Force2D force = new Force2D(8, 13);
		double expectedMagnitude = 15.264337522473748;
		double actualMagnitude = force.getMagnitude();

		Assert.assertEquals(expectedMagnitude, actualMagnitude, .01);
	}

	// @Test
	// public void testGetMagnitudeWhenXEqualsY() {
	// Force2D force = new Force2D(8, 8);
	// double expectedOutput = 11.313708498984760;
	// double actualO = force.getMagnitude();
	// Assert.assertEquals(expectedOutput, actualO, .01);
	// }

	// @Test
	// public void testGetAngle(){
	// Force2D force = new Force2D(2, 4);
	// double expectedAngle = .9640275800758;
	// double actualAngle = force.getAngle();
	//
	// Assert.assertEquals(expectedAngle, actualAngle, .01);
	// }

	@Test
	public void testAdd() {
		Force2D force1 = new Force2D(4, 6);
		Force2D force2 = new Force2D(8, 13);

		force1.add(force2);
		double expectedX = 12;
		double expectedY = 19;

		Assert.assertEquals(expectedX, force1.getX(), .1);
		Assert.assertEquals(expectedY, force1.getY(), .1);

		// Force2D expectedOutput = new Force2D(12, 19);
		// Force2D actualOutput = force1.add(force2);
		//
		// Assert.assertTrue(expectedOutput.equals(actualOutput));
	}

	@Test
	public void testAddPosAndNeg() {
		Force2D force1 = new Force2D(-3, 0);
		Force2D force2 = new Force2D(8, 6);

		Force2D expectedOutput = new Force2D(5, 6);
		Force2D actualOutput = force1.add(force2);

		Assert.assertTrue(expectedOutput.equals(actualOutput));
	}

	@Test
	public void testCommutativeAdd() {
		Force2D force1 = new Force2D(-3, 0);
		Force2D force2 = new Force2D(8, 6);

		Force2D add1 = force1.add(force2);
		Force2D add2 = force2.add(force1);

		Assert.assertTrue(add1.equals(add2));
	}
}
