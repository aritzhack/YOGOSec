package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.GameButton;
import YOGOSec.core.util.Log;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameScreen extends MyScreen {

    public static final int MARGIN = 10;
    public final int xSquares, ySquares;
    public final int SQUARE_SIZE;

    public GameScreen(Game game, int xSquares, int ySquares) {
        super(game);
        this.xSquares = xSquares;
        this.ySquares = ySquares;
        this.SQUARE_SIZE = Math.min((this.game.getWidth() - (xSquares+1) * MARGIN) / xSquares, (this.game.getHeight() - (ySquares+1) * MARGIN) / ySquares);

        this.init();
    }

    private void init() {
        for (int x = 0; x < this.xSquares; x++) {
            for (int y = 0; y < this.ySquares; y++) {
                this.addComponent(new GameButton(this, x, y));
            }
        }
    }

    public void start() {

    }

    public void stop() {

    }

    public void buttonClicked(int x, int y) {
        Log.log("Button (" + x + ", " + y + ") clicked!");
    }

}
