package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.Button;
import YOGOSec.core.gui.GUIComponent;
import YOGOSec.core.gui.IActionListener;
import YOGOSec.core.util.Rectanglef;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameScreen extends MyScreen {

    private final int xSquares, ySquares;

    public GameScreen(Game game, int xSquares, int ySquares) {
        super(game);
        this.xSquares = xSquares;
        this.ySquares = ySquares;

        this.init();
    }

    private void init() {
        for (int x = 0; x < this.xSquares; x++) {
            for (int y = 0; y < this.ySquares; y++) {
                this.addComponent(new Button(GameScreen.getButtonBounds(x, y), "", new ButtonListener(x, y)));
            }
        }
    }

    public void start() {

    }

    public void stop() {

    }

    private static Rectanglef getButtonBounds(int x, int y) {
        return null; // TODO Get bounds
    }

    private void buttonClicked(int x, int y) {

    }

    private class ButtonListener implements IActionListener {

        private final int x;
        private final int y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(GUIComponent sender) {
            GameScreen.this.buttonClicked(this.x, this.y);
        }
    }

}
