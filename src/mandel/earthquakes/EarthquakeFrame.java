package mandel.earthquakes;

import javax.swing.JFrame;
import javax.swing.JList;

public class EarthquakeFrame extends JFrame {

	private JList<EarthquakeObject> list;

	public EarthquakeFrame() throws InterruptedException {
		setTitle("Earthquake");
		setSize(350, 600);

		list = new JList<EarthquakeObject>();

		list.setCellRenderer(new CellRenderer());

		add(list);

	}

	public JList<EarthquakeObject> getList() {
		return list;
	}
}