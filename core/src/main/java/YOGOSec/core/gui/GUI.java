package YOGOSec.core.gui;

import YOGOSec.core.render.Render;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class GUI implements InputListener{

    private final List<GUIComponent> components = Lists.newArrayList();

    public abstract List<GUIComponent> getComponents();

    public void render(Render render) {
        for (GUIComponent component : this.getComponents()) {
            component.render(render);
        }
    }

    public boolean keyDown(int keycode){
        for(GUIComponent component : this.components) component.keyDown(keycode);
        return false;
    }

    public boolean keyUp(int keycode){
        for(GUIComponent component : this.components) component.keyUp(keycode);
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        for(GUIComponent component : this.components) {
            if(component.getBounds().contains(screenX, screenY)) component.touchDown(screenX, screenY, pointer, button);
        }
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for(GUIComponent component : this.components) {
            if(component.getBounds().contains(screenX, screenY)) component.touchUp(screenX, screenY, pointer, button);
        }
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        for(GUIComponent component : this.components) {
            if(component.getBounds().contains(screenX, screenY)) component.touchDragged(screenX, screenY, pointer);
        }
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        for(GUIComponent component : this.components) {
            if(component.getBounds().contains(screenX, screenY)) component.mouseMoved(screenX, screenY);
        }
        return false;
    }

    public boolean scrolled(int amount) {
        for(GUIComponent component : this.components) component.scrolled(amount);
        return false;
    }
}
