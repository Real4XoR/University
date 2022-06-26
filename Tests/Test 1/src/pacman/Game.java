// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package pacman;

import static pacman.tiles.Air.AIR;

import com.sun.source.tree.ArrayAccessTree;
import pacman.events.Event;
import pacman.events.GameOver;
import pacman.events.PlayerMove;
import pacman.tiles.*;
import pacman.util.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Represents the state of a game of Pacman. In particular, the game holds the
 * position of each piece on the board and the list of events.
 *
 * @author David J. Pearce
 *
 */
public class Game {

	private boolean won;
	/**
	 * Stores the width of the board.
	 */
	private final int width;

	/**
	 * Stores the height of the board.
	 */
	private final int height;

	/**
	 * A 2-dimensional array representing the board itself.
	 */
	private final Tile[][] board;

	/**
	 * The array of event which make up this game.
	 */
	private final Event[] events;

	/**
	 * Construct a game of Pacman
	 *
	 * @param width  Width of the board (in cells)
	 * @param height Height of the board (in cells)
	 *
	 * @param events --- The events that make up the game
	 */
	public Game(int width, int height, Event[] events) {
		this.events = events;
		this.width = width;
		this.height = height;
		board = new Tile[height][width];
	}

	/**
	 * Get the height of the game board.
	 *
	 * @return Board height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the width of the game board.
	 * @return Board width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Check whether the game is over or not. This happens when either all the dots
	 * have been collected, or the player has been eaten by a ghost.
	 *
	 * @return True if the game is over.
	 */
	public boolean isGameOver() {
		return find(Player.class) == null || find(Dot.class) == null;
	} //I tried to get this to work

	/**
	 * Run this game to produce the final board, whilst also checking each move
	 * against the rules of Pacman.
	 */
	public void run()  {
		for(int i=0;i!=events.length;++i) {
			Event move = events[i];
			move.apply(this);

			if (move instanceof PlayerMove) {
				isGameOver();
			}
		}
	}

	/**
	 * Get the tile at a given position on the board. If the position is outside the
	 * board dimensions, it just returns empty air.
	 *
	 * @param position Board position to get tile from
	 * @return Tile at given position
	 */
	public Tile getTile(Position position) {
		final int x = position.getX();
		final int y = position.getY();
		if (x < 0 || x >= width) {
			return AIR;
		} else if (y < 0 || y >= height) {
			return AIR;
		} else {
			return board[position.getY()][position.getX()];
		}
	}

	/**
	 * Swap the tiles at two positions on the board. Niether position can be outside
	 * of the board.
	 *
	 * @param p1 Board position of first tile
	 * @param p1 Board position of second tile
	 */
	public void swapTile(Position p1, Position p2) {
		final int x1 = p1.getX();
		final int y1 = p1.getY();
		final int x2 = p2.getX();
		final int y2 = p2.getY();
		// Perform the swap
		Tile tmp = board[y1][x1];
		board[y1][x1] = board[y2][x2];
		board[y2][x2] = tmp;
	}

	/**
	 * Set the tile at a given position on the board. Note, this will overwrite the
	 * record of any other tile being at that position.
	 *
	 * @param position Board position to place piece on
	 * @param tile     The tile to put at the given position.
	 */
	public void setTile(Position position, Tile tile) {
		final int x = position.getX();
		final int y = position.getY();
		if (x < 0 || x >= width) {
			return;
		} else if (y < 0 || y >= height) {
			return;
		} else {
			board[position.getY()][position.getX()] = tile;
		}
	}

	/**
	 * Locate the current position of the player.
	 *
	 * @return Position of player tile on board
	 */
	public Position locatePlayer() {
		// Find all sections
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				Position p = new Position(x,y);
				// Extract tile at x,y position
				Tile t = getTile(p);
				// Check if player
				if(t instanceof Player) {
					return p;
				}
			}
		}
		throw new IllegalArgumentException("Player not located on the board!");
	}

	public ArrayList<Position> locateGhost() {
		ArrayList<Position> ghsList = new ArrayList<>();

			for (int x = 0; x < width; ++x) {
				for (int y = 0; y < height; ++y) {
					Position p = new Position(x,y);
					// Extract tile at x,y position
					Tile t = getTile(p);
					// Check if player
					if(t instanceof Ghost) {
						ghsList.add(p);
					}
				}
			}

			return ghsList;
	}

	/**
	 * finds all instances of type x
	 *
	 * @param type
	 * @param <T>
	 * @return
	 */
	public <T extends Tile> T find(Class<T> type) {
		for (int y = 0; y != height; ++y) {
			for (int x = 0; x != width; ++x) {
				Tile t = board[y][x];
				if (type.isInstance(t)) {
					return (T) t;
				}
			}
		}
		return null;
	}

	/**
	 * Provide a human-readable view of the current game board. This is
	 * particularly useful to look at when debugging your code!
	 */
	@Override
	public String toString() {
		String r = "";
		for (int i = height - 1; i >= 0; --i) {
			r += (i%10) + "|";
			for (int j = 0; j != width; ++j) {
				Tile p = board[i][j];
				r += p.toString();
			}
			r += "|\n";
		}
		r += "  ";
		// Do the X-Axis
		for (int j = 0; j != width; ++j) {
			r += (j%10);
		}
		return r;
	}

	/**
	 * Initialse the board from a given input board. This includes the placement of
	 * all terrain and pieces.
	 *
	 * @param boardString String representing board.
	 */
	public void initialiseBoard(String boardString) {
		// You don't need to understand this!
		String[] rows = boardString.split("\n");
		for(int y=0;y!=height;++y) {
			String row = rows[y];
			for(int x=0;x!=width;++x) {
				char c = row.charAt(x+2);
				board[height-(y+1)][x] = createPieceFromChar(c);
			}
		}
	}

	/**
	 * Calculate the distance from a given position to the player's position.
	 *
	 * @param p Position
	 * @return Distance to player
	 */
	public double distanceToPlayer(Position p) {
		Position pp = locatePlayer();
		int deltaX = Math.abs(pp.getX() - p.getX());
		int deltaY = Math.abs(pp.getY() - p.getY());
		return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
	}

	/**
	 * Create a new tile from a given character in the ASCII representation of the
	 * board.
	 *
	 * @param c
	 * @return
	 */
	private Tile createPieceFromChar(char c) {
		switch(c) {
		case ' ':
			return AIR; // blank space
		case 'o':
			return new Player();
		case '*':
			break;
		case '.':
			return new Dot();
		case '#':
			return new Wall();
		case '^':
			return new Ghost("^");
		case '>':
			return new Ghost(">");
		case '<':
			return new Ghost("<");
		case 'v':
			return new Ghost("v");
		}
		throw new IllegalArgumentException("invalid character");
	}
}
