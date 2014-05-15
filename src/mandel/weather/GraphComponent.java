package mandel.weather;

import java.awt.Graphics;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5837062180754951183L;
	private int[] temps;
	private int[] days;
	private int size;

	public void setTemps(int[] temps) {
		size = temps.length;
		this.temps = temps;
		days = new int[size];
	}

	@Override
	public void paintComponent(Graphics g) {
		if (size > 0) {
			// int increment = getHeight() / 12;
			// g.drawString("200", 0, 0);
			// g.drawString("200", 0, increment);
			// g.drawString("175", 0, increment * 2);
			// g.drawString("150", 0, increment * 3);
			// g.drawString("125", 0, increment * 4);
			// g.drawString("100", 0, increment * 5);
			// g.drawString("75", 0, increment * 6);
			// g.drawString("50", 0, increment * 7);
			// g.drawString("25", 0, increment * 8);
			// g.drawString("0", 0, increment * 9);
			// g.drawString("-25", 0, increment * 10);
			// g.drawString("-50", 0, increment * 11);

			// calculate the spaces between the days
			int frameWidth = getWidth();
			int diff = frameWidth / (size - 1);
			int yPoint = 0;
			int[] tempsCopy = new int[size];
			for (int i = 0; i < size; i++) {
				days[i] = yPoint;
				yPoint += diff;

				tempsCopy[i] = getHeight() - (temps[i] + 100)
						* (getHeight() / 300);
			}

			g.drawPolyline(days, tempsCopy, size);
		}
	}
}
