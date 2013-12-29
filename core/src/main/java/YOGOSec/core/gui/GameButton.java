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
        private ButtonState state = ButtonState.NORMAL;

        public GameButtonListener(GameScreen screen, int x, int y) {
            this.screen = screen;
            this.x = x;
            this.y = y;
        }

        public void setState(ButtonState state) {
            this.state = state;
        }

        @Override
        public void actionPerformed(GUIComponent sender) {
            this.screen.buttonClicked(x, y, this.state);
        }
    }

    public GameButton(GameScreen screen, int x, int y) {
        super(GameButton.getButtonBounds(screen, x, y), "", new GameButtonListener(screen, x, y));

    }

    private static Rectanglef getButtonBounds(GameScreen screen, int x, int y) {
        return new Rectanglef(
                x * (screen.squareSize + screen.margins.getX()) + screen.margins.getX(),
                y * (screen.squareSize + screen.margins.getY()) + screen.margins.getY(),
                screen.squareSize,
                screen.squareSize);
    }

    public static enum ButtonState {
        NORMAL, LIT, UPGRADE
    }
}
