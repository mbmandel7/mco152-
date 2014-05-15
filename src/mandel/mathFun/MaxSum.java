package mandel.mathFun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxSum {

	private int[][] square;
	private ArrayList<int[][]> subRectangles;
	private int[][] maxSubRectangle;
	private int squareLength;

	public MaxSum() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		squareLength = input.nextInt();
		input.nextLine();
		if (squareLength < 101) {
			square = new int[squareLength][squareLength];
			for (int i = 0; i < squareLength; i++) {
				String inputString = input.nextLine();
				Scanner inString = new Scanner(inputString);
				for (int j = 0; j < squareLength; j++) {
					square[i][j] = inString.nextInt();
				}
			}
			subRectangles = new ArrayList<int[][]>();
		}
	}

	public MaxSum(String textFileName) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("./" + textFileName + ".txt"));
		squareLength = inFile.nextInt();
		if (squareLength > 100) {
			squareLength = 100;
		}
		square = new int[squareLength][squareLength];
		for (int i = 0; i < squareLength; i++) {
			for (int j = 0; j < squareLength; j++) {
				square[i][j] = inFile.nextInt();
			}
		}
		subRectangles = new ArrayList<int[][]>();
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				string.append(square[i][j] + " ");
			}
			string.append("\n");
		}
		return string.toString().trim();
	}

	public String maxSubRectangleToString() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < maxSubRectangle.length; i++) {
			for (int j = 0; j < maxSubRectangle[i].length; j++) {
				string.append(maxSubRectangle[i][j] + " ");
			}
			string.append("\n");
		}
		return string.toString().trim();
	}

	// public String allSubRectToString() {
	// StringBuilder string = new StringBuilder();
	// for (int[][] subRect : subRectangles) {
	// for (int i = 0; i < subRect.length; i++) {
	// for (int j = 0; j < subRect[i].length; j++) {
	// string.append(subRect[i][j] + " ");
	// }
	// string.append("\n");
	// }
	// string.append("\n\n");
	//
	// }
	// return string.toString().trim();
	//
	// }
	//
	public ArrayList<int[][]> getSubRectangles() {
		// starting at int[0][0], make int[][] of the single one and then move
		// right and then down and right.
		for (int i = 0; i < squareLength; i++) {
			for (int j = 0; j < squareLength; j++) {
				int[][] subRectangle = new int[squareLength - i][squareLength
						- j];
				// instantiate the array of int[][] that will later be added to
				// subRectangles
				for (int k = 0; k <= squareLength - i - 1; k++) {
					for (int l = 0; l <= squareLength - j - 1; l++) {
						int[][] subRect = new int[squareLength - i][squareLength
								- j];
						subRectangle[k][l] = square[i + k][j + l];
						subRect = subRectangle;
						subRect[k][l] = square[i + k][j + l];
						this.subRectangles.add(subRectangle);

					}
				}

			}
		}
		return subRectangles;
	}

	public int sumRectangle(int[][] rectangle) {
		int sum = 0;
		for (int i = 0; i < rectangle.length; i++) {
			for (int j = 0; j < rectangle[i].length; j++) {
				sum += rectangle[i][j];
			}
		}
		return sum;
	}

	public int[][] getMaxSubRectangle() {
		subRectangles = getSubRectangles();
		maxSubRectangle = subRectangles.get(1);
		int maxSum = sumRectangle(maxSubRectangle);
		for (int[][] rect : subRectangles) {
			int sum = sumRectangle(rect);
			if (maxSum < sum) {
				maxSum = sum;
				maxSubRectangle = rect;
			}
		}
		return maxSubRectangle;
	}
}