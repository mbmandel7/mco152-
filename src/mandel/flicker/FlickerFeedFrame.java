package mandel.flicker;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame {

	private JLabel[] labels = new JLabel[20];

	private static final long serialVersionUID = 1L;

	public FlickerFeedFrame() throws IOException {
		this.setTitle("Flicker");
		this.setSize(800, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			panel.add(labels[i]);
		}

		JScrollPane scroll = new JScrollPane(panel);
		add(scroll, BorderLayout.CENTER);// used to be panel instead of scroll

		Thread downloadFeedThread = new DownloadFlickerFeedThread(this);
		downloadFeedThread.start();

	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 * 
	 * @throws IOException
	 */
	public void loadImages(final FlickerFeed feed) throws IOException {
		String[] urls = feed.getArrayM();
		for (int i = 0; i < urls.length; i++) {
			Thread downloadImageThread = new DownloadImageThread(labels[i],
					urls[i]);
			downloadImageThread.start();
		}
	}

	public static void main(final String args[]) throws IOException {
		new FlickerFeedFrame().setVisible(true);

	}

}
