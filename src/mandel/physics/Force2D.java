package mandel.physics;

public class Force2D {

	private final double x;
	private final double y;

	public Force2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		return Math.sqrt((x * x) + (y * y));
	}

	public double getAngle() {
		double radians = Math.atan(y / x);
		return Math.toDegrees(radians);
	}

	public Force2D add(Force2D f) {
		return new Force2D(x + f.getX(), y + f.getY());
	}
}