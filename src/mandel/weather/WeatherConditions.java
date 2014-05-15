package mandel.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class WeatherConditions extends Thread {

	private String location;
	private Conditions cond;
	private GraphComponent graph;

	public WeatherConditions(String location, GraphComponent graph)
			throws IOException {
		this.location = location;
		this.graph = graph;
	}

	@Override
	public void run() {
		Gson gson = new Gson();
		String urlString = "http://api.openweathermap.org/data/2.5/forecast?q="
				+ location.trim() + "&mode=json";
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			cond = gson.fromJson(reader, Conditions.class);
			int[] temps = cond.getTemps();
			graph.setTemps(temps);
			graph.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Conditions getCond() {
		return cond;
	}

}
