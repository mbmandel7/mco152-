package mandel.ufo;

import java.io.IOException;

import com.google.gson.annotations.SerializedName;

public class Sighting {

	private String description;
	@SerializedName("sighted_at")
	private String sightedAt;
	@SerializedName("reported_at")
	private String reportedAt;
	private String duration;
	private String location;
	private String shape;
	private String zip;

	public Sighting(String description, String sightedAt, String reportedAt,
			String duration, String location, String shape) throws IOException {
		this.description = description;
		this.sightedAt = sightedAt;
		this.reportedAt = reportedAt;
		this.duration = duration;
		this.location = location;
		this.shape = shape;

		String city = location.substring(0, location.indexOf(','))
				.toUpperCase();
		String state = location.substring(location.indexOf(' ') + 1)
				.toUpperCase();
		ZipCodes zips = new ZipCodes("./ZIP_CODES.txt");
		for (ZipCode z : zips) {
			if (city.equals(z.getCity()) && state.equals(z.getState())) {
				this.zip = z.getZip();
				break;
			}
		}
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSightedAt() {
		return sightedAt;
	}

	public void setSightedAt(String sightedAt) {
		this.sightedAt = sightedAt;
	}

	public String getReportedAt() {
		return reportedAt;
	}

	public void setReportedAt(String reportedAt) {
		this.reportedAt = reportedAt;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zipCode) {
		this.zip = zipCode;
	}

	@Override
	public String toString() {
		return "Sighting [sightedAt=" + sightedAt + ", location=" + location
				+ ", shape=" + shape + ", zip=" + zip + "]";
	}

}
