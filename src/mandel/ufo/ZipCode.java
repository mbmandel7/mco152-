package mandel.ufo;

public class ZipCode {
	private String city;
	private String state;
	private String zip;
	private double latitude;
	private double longitude;

	public ZipCode(String zip, double latitude, double longitude, String city,
			String state) {
		this.zip = zip;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
