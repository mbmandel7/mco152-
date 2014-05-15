package mandel.mtaMap;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3059497367224605324L;

	public MainFrame() throws FileNotFoundException, IOException {
		this.setTitle("MTA Map");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, new Map());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}
