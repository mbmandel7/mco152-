package mandel.ticTacToeBoard;


import java.util.ArrayList;
import java.util.List;

public class Evaluator {

	private TicTacToeBoard ttt;
	private Symbol winner;
	private List<Location> winningSquares;

	public Evaluator(TicTacToeBoard ttt) {
		this.ttt = ttt;
		this.winner = null;
		this.winningSquares = new ArrayList<Location>(3);
	}

	public void evaluate() {
		boolean won = false;
		this.winner = Symbol.O;
		while (!won) {
			// both symbols will be checked
			if (Symbol.O.equals(winner)) {
				winner = Symbol.X;
			} else {
				winner = Symbol.O;
			}
			// check across
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					if (winner.equals(ttt.getSquare(new Location(x, y)))) {
						winningSquares.add(new Location(x, y));
					} else {
						winningSquares.clear();
						break;
					}
				}
			}
			// if winningSquares is full, end method
			if (winningSquares.size() == 3) {
				won = true;
				continue;
			}

			// check down
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					if (winner.equals(ttt.getSquare(new Location(x, y)))) {
						winningSquares.add(new Location(x, y));
					} else {
						winningSquares.clear();
						break;
					}
				}
			}
			// if winning squares is full, end method
			if (winningSquares.size() == 3) {
				won = true;
				continue;
			}
		}

		// check diagonal
		winner = ttt.getSquare(new Location(1, 1));
		if (!winner.equals(null)) {
			winningSquares.add(new Location(1, 1));
			for (int x = 0, y = 0; x < 3 && y < 3; x += 2, y += 2) {
				if (winner.equals(ttt.getSquare(new Location(x, y)))) {
					winningSquares.add(new Location(x, y));
				} else {
					winningSquares.clear();
				}
			}
			winningSquares.add(new Location(1, 1));
			if (winningSquares.size() != 3) {
				for (int x = 2, y = 0; x >= 0 && y < 3; x -= 2, y += 2) {
					if (winner.equals(ttt.getSquare(new Location(x, y)))) {
						winningSquares.add(new Location(x, y));
					} else {
						winningSquares.clear();
					}
				}
			}
		}
		if (winningSquares.isEmpty()) {
			winner = null;
		}
	}

	public Symbol getWinner() {
		return winner;
	}

	public List<Location> getWinningSquares() {
		return winningSquares;
	}
}