package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.GUI;
import YOGOSec.core.render.Render;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class MyScreen extends GUI {

    protected final Game game;
    protected final OrthographicCamera camera;
    protected int width, height;

    public MyScreen(Game game, OrthographicCamera camera) {
        this.game = game;
        this.camera = camera;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.resize(this.width, this.height);
    }

    public void render(Render render) {

    }

    public void resize(int width, int height) {
        this.camera.setToOrtho(false, width, height);
        this.width = width;
        this.height = height;
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
