package mandel.geometry;

public class Triangle {

	private int height;

	public Triangle(int height) {
		if (height > 0) {
			this.height = height;
		}
	}

	@Override
	public String toString() {
		StringBuilder triangle = new StringBuilder();
		int asterisk1 = height;
		int asterisk2 = height;
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < asterisk1; j++) {
				triangle.append(" ");
			}
			triangle.append("*");
			if (asterisk2 > asterisk1) {
				for (int j = 1; asterisk1 + j < asterisk2; j++) {
					triangle.append(" ");
				}
				triangle.append("*");
			}
			triangle.append("\n");
			asterisk1--;
			asterisk2++;
		}
		for (int i = 0; i < (height * 2) - 1; i++) {
			triangle.append("*");
		}
		return triangle.toString();
	}
}
