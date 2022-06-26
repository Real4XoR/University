package pacman.tiles;

import pacman.Game;
import pacman.events.PlayerMove.Direction;
import pacman.util.Position;

public class Ghost implements Tile{
    String direction;

    public Ghost(String d) {
        this.direction = d;
    }

    @Override
    public String toString() {
        return direction;
    }

    @Override
    public boolean isObstruction() {
        return false;
    }

    public void move(Game game, Position pp, Direction direction) {
        //Figure of new pos
        Position newPos = pp.moveWithin(direction, game.getWidth(), game.getHeight());
        Tile playerTile = game.getTile(newPos);

        if (playerTile instanceof Dot) {
            game.setTile(newPos, Air.AIR);
        }
        game.swapTile(pp, newPos);
    }
}
