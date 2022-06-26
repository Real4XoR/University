// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package pacman.events;

import pacman.Game;
import pacman.tiles.*;
import pacman.util.Position;
import pacman.io.GameError;

import java.util.ArrayList;

/**
 * Represents a directional move of the player within a given input sequence.
 *
 * @author David J. Pearce
 *
 */
public class PlayerMove implements Event {
	/**
	 * Represents one of the four directions in which the pacman can move (Up, Down,
	 * Left and Right).
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	/**
	 * Indicates the direction in which the player should move.
	 */
	private final Direction direction;

	/**
	 * Construct a new player move object for a given direction.
	 *
	 * @param direction Indicates which direction the player is moving
	 */
	public PlayerMove(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void apply(Game game) {
		// Find player's position on the board.
		Position pp = game.locatePlayer();
		// Get player object
		Player player = (Player) game.getTile(pp);
		// Move player in this direction
		Position newPos = pp.moveWithin(direction, game.getWidth(), game.getHeight());
		Tile tilePos = game.getTile(newPos);

		if (!GameOver.findDot(game)) {
			throw new GameError("Player is moving when all the dots are gone");
		}
		if (!tilePos.isObstruction()) {
			player.move(game, pp, direction);
		}
		ArrayList<Position> ghostPos = game.locateGhost();

		for (int i = 0; i < ghostPos.size(); i++) {
			Ghost ghost = (Ghost) game.getTile(ghostPos.get(i));

			if(ghost.toString().equals("^")) ghost.move(game, ghostPos.get(i), Direction.UP);
			if(ghost.toString().equals("<")) ghost.move(game, ghostPos.get(i), Direction.LEFT);
			if(ghost.toString().equals(">")) ghost.move(game, ghostPos.get(i), Direction.RIGHT);
			if(ghost.toString().equals("v")) ghost.move(game, ghostPos.get(i), Direction.DOWN);
			//making sure ghosts can't spawn on you
			//if (ghostPos.get(i).equals(newPos)) {
				//game.setNull(pp);
			//}
		}
	}
}
