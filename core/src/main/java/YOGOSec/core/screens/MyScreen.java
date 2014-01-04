package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.GUI;
import com.badlogic.gdx.Gdx;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class MyScreen extends GUI {

    protected final Game game;
    protected int width, height;

    public MyScreen(Game game) {
        this.game = game;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.resize(this.width, this.height);
    }

    public final void resize(int width, int height) {
        this.width = width;
        this.height = height;
        this.onScreenResized(width, height);
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {
        super.dispose();
    }

    public Game getGame() {
        return game;
    }

    public void onOpening(MyScreen oldScreen) {

    }

    public void onClosing(MyScreen newScreen) {

    }
}
