package mandel.ticTacToe;

import java.util.List;

import mandel.ticTacToeBoard.Evaluator;
import mandel.ticTacToeBoard.Location;
import mandel.ticTacToeBoard.Symbol;
import mandel.ticTacToeBoard.TicTacToeBoard;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testWinnerOnBlankBoard() {
		TicTacToeBoard ttt = new TicTacToeBoard();
		Evaluator ev = new Evaluator(ttt);
		ev.evaluate();
		Symbol expectedWinner = null;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);
	}

	public void testNoWinnerOnFullBoard() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(0, 0), Symbol.O);
		board.setSquare(new Location(0, 1), Symbol.X);
		board.setSquare(new Location(0, 2), Symbol.O);
		board.setSquare(new Location(1, 0), Symbol.X);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(1, 2), Symbol.X);
		board.setSquare(new Location(2, 0), Symbol.O);
		board.setSquare(new Location(2, 1), Symbol.X);
		board.setSquare(new Location(2, 2), Symbol.O);

		Symbol expectedWinner = null;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);
	}

	public void testWinnerFirstColumn() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(0, 0), Symbol.X);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(1, 0), Symbol.X);
		board.setSquare(new Location(2, 1), Symbol.O);
		board.setSquare(new Location(2, 0), Symbol.X);

		Symbol expectedWinner = Symbol.X;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);
	}

	public void testWinnerSecondColumn() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(0, 0), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(1, 0), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);
		board.setSquare(new Location(2, 0), Symbol.O);

		Symbol expectedWinner = Symbol.O;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);
	}

	public void testWinnerThirdColumn() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(1, 2), Symbol.X);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(0, 2), Symbol.X);

		Symbol expectedWinner = Symbol.X;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);
	}

	public void testWinnerFirstRow() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(0, 0), Symbol.X);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(0, 1), Symbol.X);
		board.setSquare(new Location(2, 1), Symbol.O);
		board.setSquare(new Location(0, 2), Symbol.X);

		Symbol expectedWinner = Symbol.X;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);

	}

	public void testWinnerSecondRow() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(1, 0), Symbol.X);
		board.setSquare(new Location(2, 1), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(1, 2), Symbol.X);

		Symbol expectedWinner = Symbol.X;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);
	}

	public void testWinnerThirdRow() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(2, 0), Symbol.X);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(2, 1), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);

		Symbol expectedWinner = Symbol.X;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);

	}

	public void testWinnerTopLeftDiagonal() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(0, 0), Symbol.X);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);

		Symbol expectedWinner = Symbol.X;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);

	}

	public void testWinnerTopRightDiagonal() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		board.setSquare(new Location(0, 2), Symbol.X);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(2, 0), Symbol.X);

		Symbol expectedWinner = Symbol.X;
		Symbol actualWinner = ev.getWinner();
		Assert.assertEquals(expectedWinner, actualWinner);
	}

	@Test
	public void testEvaluatorForWinningSquares() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(0, 0), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(1, 2), Symbol.X);
		board.setSquare(new Location(0, 2), Symbol.O);

		Evaluator ev = new Evaluator(board);
		ev.evaluate();
		Location[] expected = { new Location(0, 0), new Location(1, 0),
				new Location(2, 0) };
		List<Location> actual = ev.getWinningSquares();
		Assert.assertEquals(expected, actual);
	}
}