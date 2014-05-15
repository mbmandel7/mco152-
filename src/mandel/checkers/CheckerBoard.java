package mandel.checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		if (x < WIDTH && y < HEIGHT && x > -1 && y > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		if (getPiece(x, y) == null) {
			return true;
		}
		return false;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				setPiece(i, j, null);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		boolean set = false;
		int counter = 0;
		for (int i = 0; i < HEIGHT; i++) {
			if (counter < 3) {
				for (int j = 0; j < WIDTH; j++) {
					if (set) {
						setPiece(i, j, Piece.WHITE_MAN);
						set = false;
					} else {
						set = true;
					}
				}
				if (set) {
					set = false;
				} else {
					set = true;
				}
			} else {
				if (counter > 4) {
					for (int j = 0; j < WIDTH; j++) {
						if (set) {
							setPiece(i, j, Piece.RED_MAN);
							set = false;
						} else {
							set = true;
						}
					}
					if (set) {
						set = false;
					} else {
						set = true;
					}
				}
			}
			counter++;
		}
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder layout = new StringBuilder();
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				Piece p = getPiece(i, j);
				if (p == null) {
					layout.append("-");
				} else {
					layout.append(p.toString());
				}
			}
			layout.append("\n");
		}
		return layout.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		int x1 = move.getX1();
		int y1 = move.getY1();
		int x2 = move.getX2();
		int y2 = move.getY2();

		Piece p = getPiece(x1, y1);
		setPiece(x1, y1, null);

		if (!p.isKing()) {
			if (y2 == 7 || y2 == 0) {
				if (Color.WHITE.equals(p.getColor())) {
					p = Piece.WHITE_KING;
				} else {
					p = Piece.RED_KING;
				}
			}
		}
		setPiece(x2, y2, p);
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		execute(new Move(jump.getX1(), jump.getY1(), jump.getX2(), jump.getY2()));
		setPiece(jump.getCaptureX(), jump.getCaptureY(), null);
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		Piece p = getPiece(x, y);
		List<Move> moves = new ArrayList<Move>();
		if (!(null == p)) {

			if (!Piece.WHITE_MAN.equals(p)) {
				if (x > 0 && y > 0) {
					if (isEmptySquare(x - 1, y - 1)) {
						moves.add(new Move(x, y, x - 1, y - 1));
					}
				}
				if (x < 7 && y > 0) {
					if (isEmptySquare(x + 1, y - 1)) {
						moves.add(new Move(x, y, x + 1, y - 1));
					}
				}
			}
			if (!Piece.RED_MAN.equals(p)) {
				if (x > 0 && y < 7) {
					if (isEmptySquare(x - 1, y + 1)) {
						moves.add(new Move(x, y, x - 1, y + 1));
					}
				}
				if (x < 7 && y < 7) {
					if (isEmptySquare(x + 1, y + 1)) {
						moves.add(new Move(x, y, x + 1, y + 1));
					}
				}
			}
		}
		return moves;
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> jumps = new ArrayList<Jump>();
		Piece p = getPiece(x, y);
		if (!(null == p)) {
			if (!Piece.WHITE_MAN.equals(p)) {
				if (x > 1 && y > 1) {
					if (!isEmptySquare(x - 1, y - 1)) {
						if (p.isEnemyColor(getPiece(x - 1, y - 1).getColor())) {
							if (isEmptySquare(x - 2, y - 2)) {
								jumps.add(new Jump(x, y, x - 1, y - 1, x - 2,
										y - 2));
							}
						}
					}
				}
				if (x < 6 && y > 1) {
					if (!isEmptySquare(x + 1, y - 1)) {
						if (p.isEnemyColor(getPiece(x + 1, y - 1).getColor())) {
							if (isEmptySquare(x + 2, y - 2)) {
								jumps.add(new Jump(x, y, x + 1, y - 1, x + 2,
										y - 2));
							}
						}
					}
				}
			}
			if (!Piece.RED_MAN.equals(p)) {
				if (x > 1 && y < 6) {
					if (!isEmptySquare(x - 1, y + 1)) {
						if (p.isEnemyColor(getPiece(x - 1, y + 1).getColor())) {
							if (isEmptySquare(x - 2, y + 2)) {
								jumps.add(new Jump(x, y, x - 1, y + 1, x - 2,
										y + 2));
							}
						}
					}
				}
				if (x < 6 && y < 6) {
					if (!isEmptySquare(x + 1, y + 1)) {
						if (p.isEnemyColor(getPiece(x + 1, y + 1).getColor())) {
							if (isEmptySquare(x + 2, y + 2)) {
								jumps.add(new Jump(x, y, x + 1, y + 1, x + 2,
										y + 2));
							}
						}
					}
				}
			}
		}
		return jumps;
	}
}
