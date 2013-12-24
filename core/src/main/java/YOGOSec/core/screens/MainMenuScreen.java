package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.Button;
import YOGOSec.core.render.ProgressBar;
import YOGOSec.core.render.Render;
import YOGOSec.core.util.Rectangle;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MainMenuScreen extends MyScreen {

    private final ProgressBar progressBar;
    private float progress = 0.0f;

    public MainMenuScreen(Game game) {
        super(game, new OrthographicCamera());
        this.progressBar = new ProgressBar(0, 0, this.game.getWidth(), 10, 1f);
        this.addComponent(new Button(new Rectangle(-1, -1, 200, 50), "Hola", null));
        // TODO Add buttons
    }

    @Override
    public void render(Render render) {
        super.render(render);
        progress += 0.01;

        this.progressBar.setProgress((float) Math.abs(Math.sin(this.progress)));
        this.progressBar.draw(render);

    }
}
