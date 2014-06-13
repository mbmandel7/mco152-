package mandel.weather;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5004288169370764351L;

	public Frame() {
		setTitle("Weather");
		setSize(700, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		GraphComponent graph = new GraphComponent();

		add(new SelectCityPanel(graph), BorderLayout.NORTH);
		add(graph, BorderLayout.CENTER);
	}

	public static void main(String args[]) {
		Frame frame = new Frame();
		frame.setVisible(true);
	}

}
