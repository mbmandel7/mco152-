package mandel.geometry;

public class Circle2D {

	private final double x;
	private final double y;
	private final double radius;

	public Circle2D() {
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public boolean contains(double x, double y) {
		double distanceBetweenCenterAndPoint = Math.sqrt((this.x - x)
				* (this.x - x) + (this.y - y) * (this.y - y));
		return distanceBetweenCenterAndPoint < radius;
	}

	public boolean contains(Circle2D circle) {
		double distanceBetweenCenters = Math.sqrt((this.x - circle.getX())
				* (this.x - circle.getX()) + (this.y - circle.getY())
				* (this.y - circle.getY()));
		double distanceBetweenCentersPlusRadius = distanceBetweenCenters
				+ circle.getRadius();

		return distanceBetweenCentersPlusRadius < this.radius;
	}

	public boolean overlaps(Circle2D circle) {
		double distanceBetweenCenters = Math.sqrt((this.x - circle.getX())
				* (this.x - circle.getX()) + (this.y - circle.getY())
				* (this.y - circle.getY()));
		double sumOfRadii = this.radius + circle.getRadius();
		return distanceBetweenCenters < sumOfRadii;
	}
}