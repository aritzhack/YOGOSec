package YOGOSec.core.gui;

import YOGOSec.core.util.Vector2f;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface InputListener {

    public boolean keyDown(int keycode);

    public boolean keyUp(int keycode);

    public boolean touchDown(Vector2f point, int pointer, int button);

    public boolean touchUp(Vector2f point, int pointer, int button);

    public boolean touchDragged(Vector2f point, int pointer);

    public boolean mouseMoved(Vector2f point);

    public boolean scrolled(int amount);
}
