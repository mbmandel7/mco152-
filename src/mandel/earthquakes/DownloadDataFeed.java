package mandel.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DownloadDataFeed extends Thread {

	private JList<EarthquakeObject> list;

	public DownloadDataFeed(JList<EarthquakeObject> list) {
		this.list = list;
	}

	@Override
	public void run() {
		Gson gson = new Gson();
		try {
			URL url = new URL(
					"http://earthquake-report.com/feeds/recent-eq?json");
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			JsonReader jsonReader = new JsonReader(reader);
			EarthquakeObject[] feed = gson.fromJson(jsonReader,
					EarthquakeObject[].class);

			list.setListData(feed);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
