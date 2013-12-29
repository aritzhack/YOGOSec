package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.Button;
import YOGOSec.core.gui.GUIComponent;
import YOGOSec.core.gui.IActionListener;
import YOGOSec.core.gui.ProgressBar;
import YOGOSec.core.render.Render;
import YOGOSec.core.util.Rectanglef;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MainMenuScreen extends MyScreen {

    private final ProgressBar progressBar;
    private float progress = 0.0f;

    public MainMenuScreen(Game game) {
        super(game);
        this.addComponent(this.progressBar = new ProgressBar(new Rectanglef(-.5f, 0f, -1f, 20), -1f, 1f, 0f)); // Sin function goes from -1 to 1
        this.addComponent(new Button(new Rectanglef(-0.5f, -0.5f, 200, 50), "Hola", this.startGame));
        // TODO Add buttons
    }

    @Override
    public void render(Render render) {
        super.render(render);
        progress += 0.02;

        this.progressBar.setProgress(Math.sin(this.progress));
    }

    private final IActionListener startGame = new IActionListener() {
        @Override
        public void actionPerformed(GUIComponent sender) {
            MainMenuScreen.this.game.setScreen(new GameScreen(MainMenuScreen.this.game, 10, 10));
        }
    };
}
