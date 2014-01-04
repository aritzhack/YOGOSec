package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.Button;
import YOGOSec.core.gui.GUIComponent;
import YOGOSec.core.gui.IActionListener;
import YOGOSec.core.gui.Label;
import YOGOSec.core.gui.ProgressBar;
import YOGOSec.core.render.Render;
import YOGOSec.core.util.Rectanglef;
import YOGOSec.core.util.Util;
import YOGOSec.core.util.Vector2f;
import YOGOSec.core.util.Vector2i;
import com.badlogic.gdx.Gdx;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MainMenuScreen extends MyScreen {

    private static final String debug2 = "PpiX: " + Gdx.graphics.getPpiX() + " - PpiY: " + Gdx.graphics.getPpiY() + " - PpcX: " + Util.round(Gdx.graphics.getPpcX(), 2) + " - PpcY: " + Util.round(Gdx.graphics.getPpcY(), 2) + " - Res: " + Gdx.graphics.getWidth() + "x" + Gdx.graphics.getHeight();
    private final ProgressBar progressBar;
    private static final int X_SQUARES = 8, Y_SQUARES = 5;
    private final IActionListener startGame = new IActionListener() {
        @Override
        public void actionPerformed(GUIComponent sender) {
            MainMenuScreen.this.game.setScreen(MainMenuScreen.this.gameScreen);
            MainMenuScreen.this.gameScreen.start();
        }
    };
    private float progress = 0.0f;
    private GameScreen gameScreen;
    private Label label;
    private boolean init;

    public MainMenuScreen(Game game) {
        super(game);
        this.addComponent(this.progressBar = new ProgressBar(new Rectanglef(-.5f, 0f, -1f, -.05f), -1f, 1f, 0f)); // Sin function goes from -1 to 1
        this.addComponent(new Button(new Rectanglef(-0.5f, -0.5f, 200f, 50f), "Hola", this.startGame));
        if (this.game.getProxy().isDebug()) {
            this.addComponent(this.label = new Label(new Vector2f(0, 50), ""));
            this.addComponent(new Label(new Vector2f(0, 70), debug2));
        }
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
        if (!init) return;
        this.gameScreen = new GameScreen(this.game, new Vector2i(X_SQUARES, Y_SQUARES));
        if (this.game.getProxy().isDebug()) {
            this.label.setText(this.getDebugStringOne());
        }
    }

    public String getDebugStringOne() {
        return "SqPx: " + this.gameScreen.squareSize + " - SqX: " + this.gameScreen.xSquares + " - SqY: " + this.gameScreen.ySquares + " - MX: " + this.gameScreen.margins.getX() + " - MY: " + this.gameScreen.margins.getY();
    }


}
