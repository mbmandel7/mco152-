package mandel.Smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmileyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8297029879423557596L;

	public SmileyFrame() {
		this.setTitle("Smile!");
		this.setSize(800, 600);
		this.add(BorderLayout.CENTER, new SmileyFace());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		SmileyFrame frame = new SmileyFrame();
		frame.setVisible(true);
	}

}
