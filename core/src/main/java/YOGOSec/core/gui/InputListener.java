package YOGOSec.core.gui;

import YOGOSec.core.util.Vector2i;

/**
 * Simple interface that all GUI-related classes implement, so that they can handle user input
 *
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface InputListener {

    /**
     * Called when a key is pressed down.
     *
     * @param keycode The code of the key.
     * @return whether the input was processed or not.
     * @see com.badlogic.gdx.Input.Keys
     */
    public boolean keyDown(int keycode);

    /**
     * Called when a key is released.
     *
     * @param keycode The code of the key.
     * @return whether the input was processed or not.
     * @see com.badlogic.gdx.Input.Keys
     */
    public boolean keyUp(int keycode);

    /**
     * Called when a finger is pressed or the mouse clicked.
     *
     * @param point   The point at which the screen was touched or clicked.
     * @param pointer The number of the pointer that was clicked.
     * @param button  The button that was pressed, according to {@link com.badlogic.gdx.Input.Buttons Buttons}. In android it will always be {@link com.badlogic.gdx.Input.Buttons#LEFT Buttons.LEFT}.
     * @return whether the input was processed or not.
     */
    public boolean touchDown(Vector2i point, int pointer, int button);

    /**
     * Called when the finger or mouse are released.
     *
     * @param point   The point at which the screen or mouse was released.
     * @param pointer The number of the pointer that was released.
     * @param button  The button that was released, according to {@link com.badlogic.gdx.Input.Buttons Buttons}. In android it will always be {@link com.badlogic.gdx.Input.Buttons#LEFT Buttons.LEFT}.
     * @return whether the input was processed or not.
     */
    public boolean touchUp(Vector2i point, int pointer, int button);

    /**
     * Called when the finger or mouse were dragged.
     *
     * @param point   The new position of the mouse or finger.
     * @param pointer The The number of the pointer that was dragged.
     * @return whether the input was processed or not.
     */
    public boolean touchDragged(Vector2i point, int pointer);

    /**
     * Called when the mouse has been moved over the screen, but without being pressed down. Will never be called on Android.
     *
     * @param point The new position of the mouse.
     * @return whether the input was processed or not.
     */
    public boolean mouseMoved(Vector2i point);

    /**
     * Called when the mouse wheel was scrolled. Will never be called on Android.
     *
     * @param amount The direction of the scrolling: -1 = down; 1 = up.
     * @return whether the input was processed or not.
     */
    public boolean scrolled(int amount);
}
