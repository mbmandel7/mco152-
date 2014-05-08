package mandel.ticTacToeBoard;


public class TicTacToeBoard {

	private Symbol[][] board;
	private static final int ROWS = 3;
	private static final int COLUMNS = 3;

	public TicTacToeBoard() {
		board = new Symbol[ROWS][COLUMNS];
	}

	public void reset() {
		for (Symbol[] row : board) {
			row[0] = null;
			row[1] = null;
			row[2] = null;
		}
	}

	public boolean isFull() {
		for (Symbol[] row : board) {
			for (Symbol rowColumn : row) {
				if (rowColumn == null) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isEmpty() {
		for (Symbol[] row : board) {
			for (Symbol rowColumn : row) {
				if (rowColumn != null) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean setSquare(Location l, Symbol s) {
		if (board[l.getX()][l.getY()] == null) {
			board[l.getX()][l.getY()] = s;
			return true;
		}
		return false;
	}

	public Symbol getSquare(Location l) {
		return board[l.getX()][l.getY()];
	}
}