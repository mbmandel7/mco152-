package mandel.flicker;

/**
 * The class that represents the json feed from Flicker
 */
public class FlickerFeed {

	private Picture[] items;

	public String[] getArrayM() {
		String[] urls = new String[20];
		for (int i = 0; i < items.length; i++) {
			urls[i] = items[i].getM();
		}
		return urls;
	}
}

class Media {
	private String m;

	public String getM() {
		return m;
	}
}

class Picture {
	private Media media;

	public String getM() {
		return media.getM();
	}
}
