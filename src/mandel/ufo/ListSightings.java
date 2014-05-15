package mandel.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ListSightings {

	public static void main(String args[]) throws JsonIOException,
			JsonSyntaxException, IOException {

		Gson gson = new Gson();
		FileReader reader = new FileReader("ufo_awesome.json");
		SightingList list = gson.fromJson(reader, SightingList.class);
		Map<String, ArrayList<Sighting>> map = new HashMap<String, ArrayList<Sighting>>();

		for (Sighting s : list) {
			String location = s.getLocation();
			ArrayList<Sighting> sightings;
			if (!map.containsKey(location)) {
				sightings = new ArrayList<Sighting>();
				sightings.add(s);
				map.put(location, sightings);
			} else {
				sightings = map.get(location);
				sightings.add(s);
			}
		}

		System.out.println(list.size());

		// Print out all sightings for "19950115"
		for (int i = 0; i < list.size(); i++) {
			Sighting s = list.get(i);
			if ("19950115".equals(s.getSightedAt())) {
				System.out.println(s);
			}
		}

		// try {
		// while (reader.hasNext()) {
		// Sighting s = gson.fromJson(reader, Sighting.class);
		// list.add(s);
		// }
		// } catch (JsonIOException e) {
		// e.printStackTrace();
		// } catch (JsonSyntaxException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// System.out.println(list.size());
		//
		// // print out all sightings on "19950115"
		//
		// for (Sighting s : list) {
		// if ("19950115".equals(s.getSightedAt())) {
		// System.out.println(s);
		// }
		// }
		//
		// // print zip, lat, long for every sighting
		// ZipCodes zips = new ZipCodes("./ZIP_CODES.txt");
		//
		// for (Sighting s : list) {
		//
		// String location = s.getLocation().trim();
		// if (',' != location.charAt(location.length() - 1)) {
		// String city = location.substring(0, location.indexOf(','))
		// .toUpperCase();
		// String state = location.substring(location.indexOf(',') + 2)
		// .toUpperCase();
		// for (ZipCode z : zips) {
		// if (city.equals(z.getCity()) && state.equals(z.getState())) {
		// s.setZip(z.getZip());
		// System.out.println("zip: " + s.getZip() + " latitude: "
		// + z.getLatitude() + " longitude: "
		// + z.getLongitude());
		// break;
		// }
		// }
		// }
		// }
	}
}
