package mandel.clock;

public class ClockThread extends Thread {

	private ClockComponent component;

	public ClockThread(ClockComponent component) {
		this.component = component;
	}

	@Override
	public void run() {
		while (true) {
			component.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
