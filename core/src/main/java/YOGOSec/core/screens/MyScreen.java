package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.GUI;
import com.badlogic.gdx.Gdx;

/**
 * Utility class to represent each stage or screen of a game (e.g. main menu, pause menu, the game itself, etc.)
 *
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class MyScreen extends GUI {

    /**
     * The game this screen belongs to
     */
    protected final Game game;
    /**
     * The size of the screen
     */
    protected int width, height;

    /**
     * Constructs a screen belonging to the given game
     *
     * @param game The game this screen will belong to
     */
    public MyScreen(Game game) {
        this.game = game;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.resize(this.width, this.height);
    }

    /**
     * This must be called every time the screen is resized, so that the GUIComponents inside this are correctly resized or translated
     *
     * @param width  The new width of the window
     * @param height The new height of the window
     */
    public final void resize(int width, int height) {
        this.width = width;
        this.height = height;
        this.onScreenResized(width, height);
    }

    /**
     * Called when the whole app is paused
     *
     * @see MyScreen#resume()
     */
    public void pause() {

    }

    /**
     * Called when the app is resumed, after having been paused
     *
     * @see MyScreen#pause()
     */
    public void resume() {

    }

    /**
     * Returns the game this screen belongs to
     * @return the game this screen belongs to
     */
    public Game getGame() {
        return game;
    }

    /**
     * Called when this screen is being opened (when it is going to be shown into the screen)
     * @param oldScreen The screen this one is replacing
     * @see MyScreen#onClosing(MyScreen) 
     */
    public void onOpening(MyScreen oldScreen) {

    }

    /**
     * Called when this screen is being closed (when it is being replaced by another)
     * @param newScreen The screen that is replacing this one
     * @see MyScreen#onOpening(MyScreen)
     */
    public void onClosing(MyScreen newScreen) {

    }
}
