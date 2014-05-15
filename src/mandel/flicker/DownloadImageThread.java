package mandel.flicker;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a single JLabel (so we'll need 20 for 20
 * images)
 */
public class DownloadImageThread extends Thread {

	private JLabel label;
	private String url;

	public DownloadImageThread(final JLabel label, final String url) {
		this.label = label;
		this.url = url;

	}

	@Override
	public void run() {
		BufferedImage image;
		try {
			image = ImageIO.read(new URL(url));
			ImageIcon imageIcon = new ImageIcon(image);

			label.setIcon(imageIcon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
