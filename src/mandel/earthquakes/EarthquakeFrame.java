package mandel.earthquakes;

import javax.swing.JFrame;
import javax.swing.JList;

public class EarthquakeFrame extends JFrame {

	private JList<EarthquakeObject> list;

	public EarthquakeFrame() throws InterruptedException {
		setTitle("Earthquake");

		list = new JList();

		list.setCellRenderer(new CellRenderer());

		add(list);

	}

	public JList<EarthquakeObject> getList() {
		return list;
	}

	public void updateList() throws InterruptedException {
		DownloadDataFeed download = new DownloadDataFeed(list);
		download.start();
		download.sleep(60000);
	}

}
