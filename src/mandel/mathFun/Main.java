package mandel.mathFun;

public class Main {

	public static void main(String[] args) {
		MaxSum s = new MaxSum();
		// subRectangles = s.getSubRectangles();
		// StringBuilder string = new StringBuilder();
		// for (int[][] rect : subRectangles) {
		//
		// for (int i = 0; i < rect.length; i++) {
		// for (int j = 0; j < rect[i].length; j++) {
		// string.append(rect[i][j] + " ");
		// }
		// string.append("\n");
		// }
		// }
		// System.out.println(string.toString());

		int[][] maxSubRect = s.getMaxSubRectangle();
		System.out.println(s.maxSubRectangleToString());

	}

}
