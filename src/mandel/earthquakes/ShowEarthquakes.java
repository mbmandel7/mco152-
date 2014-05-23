package mandel.earthquakes;

import javax.swing.JList;

public class ShowEarthquakes {

	public static void main(String args[]) throws InterruptedException {

		EarthquakeFrame f = new EarthquakeFrame();
		JList<EarthquakeObject> list = f.getList();

		f.setVisible(true);

		while (true) {
			Thread download = new DownloadDataFeed(list);
			download.start();
			download.sleep(60000);
		}
	}

}
