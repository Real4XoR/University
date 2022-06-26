package pacman.events;

import pacman.Game;
import pacman.io.GameError;
import pacman.tiles.Dot;
import pacman.tiles.Tile;
import pacman.util.Position;

public class GameOver implements Event {
    private final boolean won;

    public GameOver(boolean won) {
        this.won = won;
    }

    @Override
    public void apply(Game game) {
        System.out.println("game over created");
        boolean foundDots = findDot(game);

        if (won && foundDots) {
            throw new GameError("Player hasn't got all the dots");
        }
        else if (!won && foundDots) {
            throw new GameError("Player shouldn't win");
        }
    }

    public static boolean findDot(Game game) {
        for (int y = 0; y != game.getHeight(); ++y) {
            for (int x = 0; x != game.getWidth(); ++x) {
                Tile d = game.getTile(new Position(x,y));
                if(d instanceof Dot) {
                    return true;
                }
            }
        }
        return false;
    }
}
