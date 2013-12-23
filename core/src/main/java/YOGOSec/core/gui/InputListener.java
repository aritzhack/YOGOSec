package YOGOSec.core.gui;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface InputListener {

    public boolean keyDown(int keycode);

    public boolean keyUp(int keycode);

    public boolean touchDown(int screenX, int screenY, int pointer, int button);

    public boolean touchUp(int screenX, int screenY, int pointer, int button);

    public boolean touchDragged(int screenX, int screenY, int pointer);

    public boolean mouseMoved(int screenX, int screenY);

    public boolean scrolled(int amount);
}
