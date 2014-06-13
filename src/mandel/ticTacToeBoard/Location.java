package mandel.ticTacToeBoard;

public class Location {

	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int compareTo(Location l) {
		if (x < l.getX()) {
			return -1;
		}
		if (x > l.getX()) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Location) {
			Location ref = (Location) o;
			return (x == ref.getX() && y == ref.getY());
		}
		return false;
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}
}