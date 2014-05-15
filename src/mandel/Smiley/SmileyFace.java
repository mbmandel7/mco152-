package mandel.Smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6286572893183427033L;

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());// this allows
															// scaling
		g.drawLine(0, getHeight(), getWidth(), 0);
		g.setColor(Color.YELLOW);
		g.fillOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(getWidth() / 2 - 25, getHeight() / 2 - 25, 10, 20);
		g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 25, 10, 20);

		g.setColor(Color.RED);
		g.drawArc(getWidth() / 2 - 30, getHeight() / 2 + 5, 60, 20, 180, 180);

	}
}
