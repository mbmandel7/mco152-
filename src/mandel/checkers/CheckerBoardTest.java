package mandel.checkers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	// * Test that isOnBoard() returns the correct result for different xs and
	// ys
	// */
	public void testIsOnBoard() {
		final CheckerBoard board = new CheckerBoard();
		Assert.assertTrue(board.isOnBoard(0, 0));
		Assert.assertFalse(board.isOnBoard(9, 10));
		Assert.assertFalse(board.isOnBoard(-1, 0));
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after
	setPiece() is called
	 */
	public void testIsEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		Assert.assertTrue(board.isEmptySquare(0, 0));
		board.setPiece(0, 0, Piece.RED_MAN);
		Assert.assertFalse(board.isEmptySquare(0, 0));
	}

	@Test
	/**
	 * Given a board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";

		Assert.assertNotSame(expected.trim(), board.toString().trim());

		board.clear();
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();

		Assert.assertNull(board.getPiece(0, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(0, 1));
		Assert.assertNull(board.getPiece(0, 2));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(0, 3));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(0, 7));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(1, 0));
		Assert.assertNull(board.getPiece(3, 5));
		Assert.assertNull(board.getPiece(4, 2));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(5, 0));
		Assert.assertNull(board.getPiece(5, 1));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(6, 3));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(7, 6));
		Assert.assertNull(board.getPiece(7, 7));
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		board.execute(new Move(1, 2, 0, 3));

		Assert.assertTrue(board.isEmptySquare(1, 2));
		Assert.assertFalse(board.isEmptySquare(0, 3));
		Assert.assertFalse(board.getPiece(0, 3).isKing());
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to
	the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 6, Piece.WHITE_MAN);
		Move move = new Move(1, 6, 0, 7);
		board.execute(move);
		boolean promoted = board.getPiece(0, 7).isKing();
		Assert.assertTrue(promoted);
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the
	1st row
	 */
	public void testMovePromoteToRedKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 1, Piece.RED_MAN);
		Move move = new Move(0, 1, 1, 0);
		board.execute(move);
		boolean promoted = board.getPiece(1, 0).isKing();
		Assert.assertTrue(promoted);
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes
	the piece that was jumped
	 */
	public void testJump() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 5, Piece.RED_MAN);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		Jump jump = new Jump(4, 5, 3, 4, 2, 3);
		board.execute(jump);

		Assert.assertTrue(board.isEmptySquare(4, 5));
		Assert.assertTrue(board.isEmptySquare(3, 4));
		Assert.assertFalse(board.isEmptySquare(2, 3));
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the
	1st row
	 */
	public void testJumpPromoteToRedKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 2, Piece.RED_MAN);
		board.setPiece(2, 1, Piece.WHITE_MAN);
		Jump jump = new Jump(3, 2, 2, 1, 1, 0);
		board.execute(jump);

		boolean promoted = board.getPiece(1, 0).isKing();
		Assert.assertTrue(promoted);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to
	the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.WHITE_MAN);
		board.setPiece(1, 6, Piece.RED_MAN);
		Jump jump = new Jump(2, 5, 1, 6, 0, 7);
		board.execute(jump);

		boolean promoted = board.getPiece(0, 7).isKing();
		Assert.assertTrue(promoted);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when
	called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		List<Move> moves = board.getMoves(0, 0);
		List<Move> expected = new ArrayList<Move>();
		Assert.assertEquals(expected, moves);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is
	in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 2, Piece.RED_MAN);
		List<Move> moves = board.getMoves(1, 2);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(1, 2, 0, 1));
		expected.add(new Move(1, 2, 2, 1));

		Assert.assertEquals(expected, moves);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING
	is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 2, Piece.RED_KING);
		List<Move> moves = board.getMoves(1, 2);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(1, 2, 0, 1));
		expected.add(new Move(1, 2, 2, 1));
		expected.add(new Move(1, 2, 0, 3));
		expected.add(new Move(1, 2, 2, 3));
		Assert.assertEquals(4, moves.size());
		Assert.assertEquals(expected, moves);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a WHITE_MAN
	is
	in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.WHITE_MAN);
		List<Move> moves = board.getMoves(3, 4);
		List<Move> expectedMoves = new ArrayList<Move>();
		expectedMoves.add(new Move(3, 4, 2, 5));
		expectedMoves.add(new Move(3, 4, 4, 5));

		Assert.assertEquals(expectedMoves, moves);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a WHITE_KING
	is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 2, Piece.WHITE_KING);
		List<Move> moves = board.getMoves(5, 2);
		List<Move> expectedMoves = new ArrayList<Move>();
		expectedMoves.add(new Move(5, 2, 4, 1));
		expectedMoves.add(new Move(5, 2, 6, 1));
		expectedMoves.add(new Move(5, 2, 4, 3));
		expectedMoves.add(new Move(5, 2, 6, 3));

		Assert.assertEquals(expectedMoves, moves);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING
	is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(2, 3, Piece.WHITE_KING);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		board.setPiece(2, 5, Piece.RED_MAN);
		board.setPiece(4, 5, Piece.RED_MAN);
		List<Move> moves = board.getMoves(3, 4);
		List<Move> expected = new ArrayList<Move>();

		Assert.assertEquals(expected, moves);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the
	board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> moves = board.getMoves(0, 7);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(0, 7, 1, 6));

		Assert.assertEquals(expected, moves);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the
	board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> moves = board.getMoves(7, 0);
		List<Move> expected = new ArrayList<Move>();
		expected.add(new Move(7, 0, 6, 1));

		Assert.assertEquals(expected, moves);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when
	called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		List<Jump> expectedJumps = new ArrayList<Jump>();
		List<Jump> actualJumps = board.getJumps(2, 3);
		Assert.assertEquals(expectedJumps, actualJumps);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when
	called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.RED_KING);
		List<Jump> actualJumps = board.getJumps(2, 3);
		List<Jump> expectedJumps = new ArrayList<Jump>();

		Assert.assertEquals(expectedJumps, actualJumps);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can
	jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.RED_KING);
		board.setPiece(1, 2, Piece.WHITE_MAN);
		board.setPiece(3, 2, Piece.WHITE_MAN);
		board.setPiece(1, 4, Piece.WHITE_MAN);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		List<Jump> actualJumps = board.getJumps(2, 3);
		List<Jump> expectedJumps = new ArrayList<Jump>();
		expectedJumps.add(new Jump(2, 3, 1, 2, 0, 1));
		expectedJumps.add(new Jump(2, 3, 3, 2, 4, 1));
		expectedJumps.add(new Jump(2, 3, 1, 4, 0, 5));
		expectedJumps.add(new Jump(2, 3, 3, 4, 4, 5));

		Assert.assertEquals(expectedJumps, actualJumps);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when
	a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 5, Piece.RED_MAN);
		board.setPiece(5, 4, Piece.WHITE_MAN);
		board.setPiece(3, 4, Piece.WHITE_KING);
		List<Jump> actualJumps = board.getJumps(4, 5);
		List<Jump> expectedJumps = new ArrayList<Jump>();
		expectedJumps.add(new Jump(4, 5, 3, 4, 2, 3));
		expectedJumps.add(new Jump(4, 5, 5, 4, 6, 3));

		Assert.assertEquals(expectedJumps, actualJumps);
	}

}
