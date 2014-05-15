package mandel.mtaMap;

public class Trip {

	private String routeID;
	private String tripID;

	public Trip(String routeID, String tripID) {
		this.routeID = routeID;
		this.tripID = tripID;
	}

	public String getTripID() {
		return tripID;
	}

	public String getRouteID() {
		return routeID;
	}
}