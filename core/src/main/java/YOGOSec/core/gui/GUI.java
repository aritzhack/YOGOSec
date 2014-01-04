package YOGOSec.core.gui;

import YOGOSec.core.render.Render;
import YOGOSec.core.util.Log;
import YOGOSec.core.util.Vector2i;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Abstract class with all the basics to use as a GUIComponents container.
 * Draws all its components every time, in the order they were added.
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class GUI implements InputListener {

    /**
     * The list containing all the components of this GUI
     */
    protected final List<GUIComponent> components = Lists.newArrayList();

    /**
     * This must be called every render cycle, so that its components are drawn.
     * @param render The renderer to use
     */
    public void render(Render render) {
        for (GUIComponent component : this.components) component.render(render);
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
    public boolean touchDown(Vector2i point, int pointer, int button) {
        for (GUIComponent component : this.components) component.touchDown(point, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2i point, int pointer, int button) {
        for (GUIComponent component : this.components) component.touchUp(point, pointer, button);
        return false;
    }

    @Override
    public boolean touchDragged(Vector2i point, int pointer) {
        for (GUIComponent component : this.components) component.touchDragged(point, pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(Vector2i point) {
        for (GUIComponent component : this.components) component.mouseMoved(point);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        for (GUIComponent component : this.components) component.scrolled(amount);
        return false;
    }

    /**
     * Adds a GUIComponent to this GUI
     * Just prettier than accessing the list directly
     * @param component The component to add
     */
    public void addComponent(GUIComponent component) {
        this.components.add(component);
    }

    /**
     * This must be called each time the screen is resized, so that the components relocate and resize as needed
     * @param width The new width of the screen
     * @param height The new height of the screen
     */
    public void onScreenResized(int width, int height) {
        for (GUIComponent component : this.components) component.onGUIResized(width, height);
    }

    /**
     * This must be called whenever this GUI will no longer be used, so that the resources it uses can be freed
     */
    public void dispose() {
        Log.log("Disposing...");
        for (GUIComponent component : this.components) component.dispose();
    }
}
