package mandel.earthquakes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CellRenderer extends JLabel implements
		ListCellRenderer<EarthquakeObject> {

	public CellRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(
			JList<? extends EarthquakeObject> list, EarthquakeObject value,
			int index, boolean isSelected, boolean cellHasFocus) {
		double magnitude = value.getMagnitude();
		setText(magnitude + " " + value.getLocation());
		Color foreground;
		return this;
	}

}
