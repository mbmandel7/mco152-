package mandel.mtaMap;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

public class Trips extends Thread {

	private HashMap<String, Trip> trips;

	@Override
	public void run() {
		this.trips = new HashMap<String, Trip>();
		try {
			@SuppressWarnings("resource")
			CSVReader reader = new CSVReader(new FileReader("./trips.txt"),
					',', '\"', 1);
			String[] nextLine;
			String routeID;
			String tripID;
			String shapeID;
			while ((nextLine = reader.readNext()) != null) {
				routeID = nextLine[0];
				tripID = nextLine[2];
				shapeID = nextLine[6];
				trips.put(shapeID, new Trip(routeID, tripID));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Trip getTrip(String shapeID) throws IOException {
		return trips.get(shapeID);
	}
}