package mandel.ticTacToe;

import mandel.ticTacToeBoard.Location;
import mandel.ticTacToeBoard.Symbol;
import mandel.ticTacToeBoard.TicTacToeBoard;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void testGetSquare() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.X);
		Symbol actual = board.getSquare(new Location(0, 0));

		Assert.assertEquals(Symbol.X, actual);
	}

	@Test
	public void testGetSquareFalse() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.X);
		Symbol actual = board.getSquare(new Location(0, 0));

		Assert.assertNotSame(Symbol.O, actual);
	}

	@Test
	public void testIsEmpty() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.O);

		Assert.assertFalse(board.isFull());
	}

	@Test
	public void testIsFull() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.O);
		board.setSquare(new Location(0, 1), Symbol.X);
		board.setSquare(new Location(0, 2), Symbol.O);
		board.setSquare(new Location(1, 0), Symbol.X);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(1, 2), Symbol.X);
		board.setSquare(new Location(2, 0), Symbol.O);
		board.setSquare(new Location(2, 1), Symbol.X);
		board.setSquare(new Location(2, 2), Symbol.O);

		Assert.assertTrue(board.isFull());
	}

	@Test
	public void testSetExistingSquare() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.O);
		boolean result = board.setSquare(new Location(0, 0), Symbol.O);

		Assert.assertFalse(result);
	}

	@Test
	public void testReset() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(0, 2), Symbol.X);
		board.setSquare(new Location(1, 0), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(1, 2), Symbol.O);

		board.reset();

		Assert.assertTrue(board.isEmpty());
	}
}