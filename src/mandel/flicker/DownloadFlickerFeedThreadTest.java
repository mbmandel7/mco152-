package mandel.flicker;

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mockito;

public class DownloadFlickerFeedThreadTest {

	@Test
	public void testCallsLoadImages() throws IOException {// testing that thread
		// worked and that
		// networking code
		// is in the run
		// method, not in
		// the constructor

		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);

		Mockito.verify(frame, Mockito.never()).loadImages(
				Mockito.any(FlickerFeed.class));

		thread.run();// in this situation, we don't want to run things in a
						// separate thread. We don't want to wait for the thread
						// to finish. so we call run(), not start()!

		Mockito.verify(frame, Mockito.times(1)).loadImages(
				Mockito.any(FlickerFeed.class));// checking that loadImages was
												// called once. feed is
												// underlined because it was
												// created in the thread. how do
												// i get around this?
												// Mockito.any()
	}
}