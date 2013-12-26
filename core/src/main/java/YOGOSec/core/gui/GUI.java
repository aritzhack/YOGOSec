package YOGOSec.core.gui;

import YOGOSec.core.render.Render;
import YOGOSec.core.util.Point2i;
import com.badlogic.gdx.Gdx;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class GUI implements InputListener {

    protected final List<GUIComponent> components = Lists.newArrayList();

    public void render(Render render) {
        for (GUIComponent component : this.components) {
            component.render(render);
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        for (GUIComponent component : this.components) component.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        for (GUIComponent component : this.components) component.keyUp(keycode);
        return false;
    }

    @Override
    public boolean touchDown(Point2i point, int pointer, int button) {
        for (GUIComponent component : this.components) {
            component.touchDown(point, pointer, button);
        }
        return false;
    }

    @Override
    public boolean touchUp(Point2i point, int pointer, int button) {
        for (GUIComponent component : this.components) {
            component.touchUp(point, pointer, button);
        }
        return false;
    }

    @Override
    public boolean touchDragged(Point2i point, int pointer) {
        for (GUIComponent component : this.components) {
            component.touchDragged(point, pointer);
        }
        return false;
    }

    @Override
    public boolean mouseMoved(Point2i point) {
        for (GUIComponent component : this.components) {
            if (component.getBounds().contains(point)) component.mouseMoved(point);
        }
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        for (GUIComponent component : this.components) component.scrolled(amount);
        return false;
    }

    public void addComponent(GUIComponent component) {
        this.components.add(component);
    }

    public void onScreenResized(int width, int height) {
        for (GUIComponent component : this.components) {
            component.onGUIResized(width, height);
        }
    }

    public void dispose() {
        Gdx.app.log("YOGOSec", "Disposing...");
        for(GUIComponent component : this.components) {
            component.dispose();
        }
    }
}
