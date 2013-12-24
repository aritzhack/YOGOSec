package YOGOSec.core.gui;

import YOGOSec.core.render.Render;
import YOGOSec.core.util.Point;
import YOGOSec.core.util.Rectangle;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class GUIComponent implements InputListener {

    protected Rectangle bounds;

    public GUIComponent(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void render(Render render) {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(Point point, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(Point point, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(Point point, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(Point point) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
