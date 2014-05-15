package mandel.mtaMap;

public class Shape {

	private String shapeID;
	private double latitude;
	private double longitude;

	public Shape(String shapeID, double latitude, double longitude) {
		this.shapeID = shapeID;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getShapeID() {
		return shapeID;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;// if you multiply this by -1,the map will appear
							// upside down
	}
}
