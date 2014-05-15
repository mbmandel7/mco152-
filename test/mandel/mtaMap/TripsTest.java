package mandel.mtaMap;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TripsTest {

	@Test
	public void testInstantiateTrips() throws FileNotFoundException,
			IOException {
		new Trips();
	}
	
	@Test
	public void testGetTrip() throws IOException{
		final Trips trips = new Trips();
		Assert.assertNotNull("ShapeID 1..S03R not found", trips.getTrip("1..S03R"));
	}

}
