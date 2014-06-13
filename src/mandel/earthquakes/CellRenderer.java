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

		if (magnitude < 5) {
			setBackground(Color.decode("#66FFFF"));
		} else {
			if (magnitude < 7) {
				setBackground(Color.decode("#FFFF99"));
			} else {
				if (magnitude < 8) {
					setBackground(Color.decode("#FF99FF"));
				} else {
					if (magnitude < 10) {
						setBackground(Color.decode("FFFFFFF"));
					} else {
						setBackground(Color.decode("FF0000"));
					}
				}
			}
		}

		return this;
	}

}
