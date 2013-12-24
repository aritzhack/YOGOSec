package YOGOSec.core.gui;

import YOGOSec.core.util.Point;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface InputListener {

    public boolean keyDown(int keycode);

    public boolean keyUp(int keycode);

    public boolean touchDown(Point point, int pointer, int button);

    public boolean touchUp(Point point, int pointer, int button);

    public boolean touchDragged(Point point, int pointer);

    public boolean mouseMoved(Point point);

    public boolean scrolled(int amount);
}
