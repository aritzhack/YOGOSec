package YOGOSec.core.gui;

import YOGOSec.core.screens.GameScreen;
import YOGOSec.core.util.Rectanglef;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameButton extends Button {

    private static class GameButtonListener implements IActionListener {

        private final GameScreen screen;
        private final int x;
        private final int y;

        public GameButtonListener(GameScreen screen, int x, int y) {
            this.screen = screen;
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(GUIComponent sender) {
            this.screen.buttonClicked(x, y);
        }
    }

    public GameButton(GameScreen screen, int x, int y) {
        super(GameButton.getButtonBounds(screen, x, y), "", new GameButtonListener(screen, x, y));

    }

    private static Rectanglef getButtonBounds(GameScreen screen, int x, int y) {
        return new Rectanglef(
                x * (screen.SQUARE_SIZE + GameScreen.MARGIN) + GameScreen.MARGIN,
                y * (screen.SQUARE_SIZE + GameScreen.MARGIN) + GameScreen.MARGIN,
                screen.SQUARE_SIZE,
                screen.SQUARE_SIZE);
    }
}
