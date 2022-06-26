// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.logic;

import java.util.Iterator;
import swen221.tetris.moves.Move;
import swen221.tetris.tetromino.*;

/**
 * A Game instance represents a running game of Tetris. It accepts game moves
 * and updates the board accordingly. Likewise, it provides an API to access the
 * board itself. Finally, it determines when the game is over (i.e. because the
 * board is full).
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
public class Game {
	/**
	 * An (infinite) sequence of tetrominos to be used to determine the next tetromino.
	 */
	private final Iterator<Tetromino> tetrominoSequence;

	/**
	 * The next tetromnino to be issued. This is useful, amongst other things, for
	 * showing the user what is coming next.
	 */
	private ActiveTetromino nextTetromino;

	/**
	 * The current state of the game board.
	 */
	private Board board;

	/**
	 * Records the number of lines which have been removed.
	 */
	private int lines;
	/**
	 * Records the current score which is determined as a function of the number of
	 * lines removed.
	 */
	private int score;

	/**
	 * Construct a new game instance for a given sequence of tetromino, and assuming
	 * given board dimensions.
	 *
	 * @param sequence The sequence of tetromino to use during the game.
	 * @param width    The width (in columns) of the board.
	 * @param height   The height (in rows) of the board.
	 */
	public Game(Iterator<Tetromino> sequence, int width, int height) {
		this.tetrominoSequence = sequence;
		// Initial boards list with an empty board.
		this.board = new Board(sequence, width, height);
		// Initialise next tetromino
		this.nextTetromino = nextActiveTetromino();
	}

	/**
	 * Get number of lines removed.
	 *
	 * @return The number of lines removed.
	 */
	public int getLines() {
		return lines;
	}

	/**
	 * Get the current score.
	 *
	 * @return The current score.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Get the current board being acted upon.
	 *
	 * @return The current board.
	 */
	public Board getActiveBoard() {
		return board;
	}

	/**
	 * Get the next tetromino which will be issued.
	 *
	 * @return The next tetromino.
	 */
	public Tetromino getNextTetromino() {
		return nextTetromino.getUnderlyingTetromino();
	}

	/**
	 * Check whether the game is over. This happens when we can no longer place the
	 * next tetromino.
	 *
	 * @return True if the game is over, false otherwise.
	 */
	public boolean isGameOver() {
		// Game is over when can no longer place next tetromino
		return !board.canPlaceTetromino(nextTetromino);
	}

	/**
	 * Reset the game so another can be played.
	 */
	public void reset() {
		// reset the line count
		this.lines = 0;
		// reset the score
		this.score = 0;
		// reset the board
		this.board = new Board(tetrominoSequence, board.getWidth(), board.getHeight());
	}

	/**
	 * Apply a given move to the board. This will update the board if the move is
	 * valid, otherwise it will be ignored.
	 *
	 * @param move The move to apply to the given board.
	 * @return True if the move was applied, false otherwise.
	 */
	public boolean apply(Move move) {
		// Check whether the move was valid as, if not, then it's ignored.
		Board temp = new Board(board);
		temp = move.apply(temp);
		ActiveTetromino tempTet = temp.getActiveTetromino();
		if (tempTet != null && temp.canPlaceTetromino(tempTet) && checkBoundaries(tempTet)) {
			// Yes, move is valid therefore apply it for real.
			board = move.apply(board);
			//
			return true;
		} else {
			// This move was ignored.
			return false;
		}
	}

	public boolean checkBoundaries(ActiveTetromino t) {
		return t.getBoundingBox().getMaxX() < board.getWidth() && t.getBoundingBox().getMinX() >= 0 && t.getBoundingBox().getMaxY() < board.getHeight() && t.getBoundingBox().getMinY() >= 0;
	}

	/**
	 * Clock the game for another cycle. This will apply gravity to the board and
	 * check whether or not the active tetromino has landed. If the piece has
	 * landed, then we will remove full rows, etc.
	 */
	public void clock() {
		//
		ActiveTetromino activeTetromino = board.getActiveTetromino();
		// Check whether it has landed
		if (activeTetromino != null) {
			if (!board.canPlaceTetromino(activeTetromino.translate(0, -1))){
				board.placeTetromino(activeTetromino);
				activeTetromino = null;
			} else{
				// apply gravity
				activeTetromino = activeTetromino.translate(0, -1);
			}
		} else if(board.canPlaceTetromino(nextTetromino)){
			// promote next tetromino to be active
			activeTetromino = nextTetromino;
			// select the next one in sequence
			nextTetromino = nextActiveTetromino();
		} else {
			// indicates game over status

		}
		board.setActiveTetromino(activeTetromino);
		if (board.getActiveTetromino() == null) {
			//Setting relevant fields for the game over status
			int rowsRemoved = board.removeFullRows();
			this.score = this.score + (rowsRemoved*100);
			this.lines = this.lines + rowsRemoved;
		}
	}


	// ======================================================================
	// Helper methods
	// ======================================================================

	/**
	 * Determine the next active tetromino for the board.
	 *
	 * @return The next active tetromino.
	 */
	private ActiveTetromino nextActiveTetromino() {
		// Determine center for next tetromino
		int cx = board.getWidth() / 2;
		int cy = board.getHeight() - 2;
		// set next tetromino
		return new ActiveTetromino(cx, cy, tetrominoSequence.next());
	}
}
