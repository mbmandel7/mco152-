package mandel.mtaMap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

public class Routes extends Thread {

	private HashMap<String, Color> routes;

	@Override
	public void run() {
		this.routes = new HashMap<String, Color>();
		try {
			@SuppressWarnings("resource")
			CSVReader reader = new CSVReader(new FileReader("./routes.txt"),
					',', '\"', 1);
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				String routeID = nextLine[0];
				if ("".compareTo(nextLine[7]) != 0) {
					Color color = Color.decode("#" + nextLine[7]);
					routes.put(routeID, color);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Color getColor(String routeID) {
		return routes.get(routeID);
	}
}