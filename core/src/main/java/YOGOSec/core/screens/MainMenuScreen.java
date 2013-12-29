package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.Button;
import YOGOSec.core.gui.GUIComponent;
import YOGOSec.core.gui.IActionListener;
import YOGOSec.core.gui.Label;
import YOGOSec.core.gui.ProgressBar;
import YOGOSec.core.render.Render;
import YOGOSec.core.util.Point2f;
import YOGOSec.core.util.Rectanglef;
import YOGOSec.core.util.Util;
import com.badlogic.gdx.Gdx;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MainMenuScreen extends MyScreen {

    private final ProgressBar progressBar;
    private float progress = 0.0f;
    private GameScreen gameScreen;
    private Label label;
    private boolean init;

    public MainMenuScreen(Game game) {
        super(game);
        this.gameScreen = new GameScreen(this.game);
        this.addComponent(this.progressBar = new ProgressBar(new Rectanglef(-.5f, 0f, -1f, 20), -1f, 1f, 0f)); // Sin function goes from -1 to 1
        this.addComponent(new Button(new Rectanglef(-0.5f, -0.5f, 200, 50), "Hola", this.startGame));
        this.addComponent(this.label = new Label(new Point2f(0, 50), this.getDebugStringOne()));
        final String debug2 = "PpiX: " + Gdx.graphics.getPpiX() + " - PpiY: " + Gdx.graphics.getPpiY() + " - PpcX: " + Util.round(Gdx.graphics.getPpcX(), 2) + " - PpcY: " + Util.round(Gdx.graphics.getPpcY(), 2) + " - Res: " + Gdx.graphics.getWidth() + "x" + Gdx.graphics.getHeight();
        this.addComponent(new Label(new Point2f(0, 70), debug2));
        this.init = true;
        // TODO Add buttons
    }

    @Override
    public void render(Render render) {
        super.render(render);
        progress += 0.02;

        this.progressBar.setProgress(Math.sin(this.progress));
    }

    @Override
    public void onScreenResized(int width, int height) {
        super.onScreenResized(width, height);
        if(!init) return;
        this.gameScreen = new GameScreen(this.game);
        this.label.setText(this.getDebugStringOne());
    }

    public String getDebugStringOne() {
        return "SqPx: " + this.gameScreen.squareSize + " - SqX: " + this.gameScreen.xSquares + " - SqY: " + this.gameScreen.ySquares + " - MX: " + this.gameScreen.margins.getX() + " - MY: " + this.gameScreen.margins.getY();
    }

    private final IActionListener startGame = new IActionListener() {
        @Override
        public void actionPerformed(GUIComponent sender) {
            MainMenuScreen.this.game.setScreen(MainMenuScreen.this.gameScreen);
        }
    };


}
