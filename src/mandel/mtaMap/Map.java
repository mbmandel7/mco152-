package mandel.mtaMap;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;

public class Map extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8161081999038749172L;
	private Routes routes;
	private Shapes shapes;
	private Trips trips;

	public Map() throws FileNotFoundException, IOException {
		routes = new Routes();
		shapes = new Shapes();
		trips = new Trips();
		routes.start();
		shapes.start();
		trips.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		try {
			routes.join();
			shapes.join();
			trips.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> shapeIdIndex = shapes.shapeIdIndex();
		Trip trip;
		String routeID;
		Color color;
		for (String shapeId : shapeIdIndex) {
			try {
				trip = trips.getTrip(shapeId);
				if (trip != null) {
					routeID = trip.getRouteID();
					color = routes.getColor(routeID);
					g.setColor(color);
					List<Shape> shapeList = shapes.getShapes(shapeId);
					double minLatitude = shapes.getMinLatitude();
					double maxLatitude = shapes.getMaxLatitude();
					double minLongitude = shapes.getMinLongitude();
					double maxLongitude = shapes.getMaxLongitude();
					for (int i = 0; i < shapeList.size() - 1; i++) {
						double latitude1 = shapeList.get(i).getLatitude();
						double latitude2 = shapeList.get(i + 1).getLatitude();
						double longitude1 = shapeList.get(i).getLongitude();
						double longitude2 = shapeList.get(i + 1).getLongitude();
						int pixel1X = (int) ((latitude1 - minLatitude)
								/ (maxLatitude - minLatitude) * (getWidth() - 0));
						int pixel1Y = (int) ((longitude1 - minLongitude)
								/ (maxLongitude - minLongitude) * (getHeight() - 0));
						int pixel2X = (int) ((latitude2 - minLatitude)
								/ (maxLatitude - minLatitude) * (getWidth() - 0));
						int pixel2Y = (int) ((longitude2 - minLongitude)
								/ (maxLongitude - minLongitude) * (getHeight() - 0));
						g.drawLine(pixel1X, pixel1Y, pixel2X, pixel2Y);
					}
				}

			} catch (IOException e) {
				System.out.println("IOException");
			}
		}
	}
}