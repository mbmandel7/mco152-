package mandel.primeNumbers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayPrime extends JFrame implements ActionListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6161337885828703598L;
	private JButton start;
	private JTextArea area;
	private JScrollPane scroll;

	public DisplayPrime() {

		start = new JButton("START");
		area = new JTextArea();

		this.setTitle("Prime Numbers");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		scroll = new JScrollPane(area);
		add(start, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);

		start.addActionListener(this);
	}

	public static void main(String args[]) {
		DisplayPrime display = new DisplayPrime();
		display.setVisible(true);
	}

	@Override
	public void run() {
		for (int i = 1; i < 10000000; i++) {
			if (isPrime(i)) {
				area.append(String.valueOf(i));
				area.append("\n");
			}
		}
	}

	public boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
	}
}