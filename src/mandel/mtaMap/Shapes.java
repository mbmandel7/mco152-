package mandel.mtaMap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes extends Thread {

	private List<Shape> shapes;

	@Override
	public void run() {
		this.shapes = new ArrayList<Shape>();
		try {
			@SuppressWarnings("resource")
			CSVReader reader = new CSVReader(new FileReader("./shapes.txt"),
					',', '\"', 1);
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				String shapeId = nextLine[0];
				Double latitude = Double.valueOf(nextLine[1]);
				Double longitude = Double.valueOf(nextLine[2]);
				shapes.add(new Shape(shapeId, latitude, longitude));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Shape> getShapes(String shapeID) {
		List<Shape> shape = new ArrayList<Shape>();
		for (Shape s : shapes) {
			if (shapeID.equals(s.getShapeID())) {
				shape.add(s);
			}
		}
		return shape;
	}

	public List<String> shapeIdIndex() {
		List<String> shapeIdIndex = new ArrayList<String>();
		String index = null;
		for (Shape s : shapes) {
			if (!s.getShapeID().equals(index)) {
				index = s.getShapeID();
				shapeIdIndex.add(index);
			}
		}
		return shapeIdIndex;
	}

	public Double getMinLatitude() {
		double min = shapes.get(0).getLatitude();
		for (Shape s : shapes) {
			if (min > s.getLatitude()) {
				min = s.getLatitude();
			}
		}
		return min;
	}

	public Double getMinLongitude() {
		double min = shapes.get(0).getLongitude();
		for (Shape s : shapes) {
			if (min > s.getLongitude()) {
				min = s.getLongitude();
			}
		}
		return min;
	}

	public double getMaxLatitude() {
		double max = shapes.get(0).getLatitude();
		for (Shape s : shapes) {
			if (max < s.getLatitude()) {
				max = s.getLatitude();
			}
		}
		return max;
	}

	public double getMaxLongitude() {
		double max = shapes.get(0).getLongitude();
		for (Shape s : shapes) {
			if (max < s.getLongitude()) {
				max = s.getLongitude();
			}
		}
		return max;
	}
}