package mandel.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DisplayPi extends JFrame implements ActionListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5799516187529678678L;
	private JButton start;
	private JTextArea area;

	public DisplayPi() {

		start = new JButton("START");
		area = new JTextArea();

		this.setTitle("PI");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(start, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		start.addActionListener(this);
	}

	public static void main(String args[]) {
		DisplayPi display = new DisplayPi();
		display.setVisible(true);
	}

	@Override
	public void run() {
		double pi = 0;
		for (int i = 1; i < 1000000000; i++) {
			pi += 4 * (Math.pow((-1), (i + 1)) / (2 * i - 1));
			area.setText(String.valueOf(pi));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
	}

}
