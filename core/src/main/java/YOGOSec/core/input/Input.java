package YOGOSec.core.input;

import YOGOSec.core.Game;
import com.badlogic.gdx.InputProcessor;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Input implements InputProcessor {
    private final Game game;

    public Input(Game game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        return this.game.getScreen().keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return this.game.getScreen().keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return this.game.getScreen().touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return this.game.getScreen().touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return this.game.getScreen().touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return this.game.getScreen().mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(int amount) {
        return this.game.getScreen().scrolled(amount);
    }
}
