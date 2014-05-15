package mandel.clock;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ClockFrame extends JFrame {

	private static final long serialVersionUID = 5156394613608607683L;
	private ClockComponent viewClock;

	public ClockFrame() throws InterruptedException {

		setTitle("Clock");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		viewClock = new ClockComponent();
		add(BorderLayout.CENTER, viewClock);

		Thread t = new ClockThread(viewClock);
		t.start();
	}

	public static void main(String args[]) throws InterruptedException {

		ClockFrame frame = new ClockFrame();
		frame.setVisible(true);

	}

}
