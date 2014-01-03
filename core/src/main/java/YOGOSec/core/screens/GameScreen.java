package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.GameButton;
import YOGOSec.core.gui.ProgressBar;
import YOGOSec.core.util.GameLogic;
import YOGOSec.core.util.Log;
import YOGOSec.core.util.Rectanglef;
import YOGOSec.core.util.Vector2i;
import com.badlogic.gdx.Gdx;
import com.google.common.base.Preconditions;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameScreen extends MyScreen {

    public static final float MIN_MARGIN_IN_CM = 5f / 8f;
    public static final float RECOMMENDED_SQUARE_CMS = 1f;
    public static final float TOP_MARGIN_PERCENT = 0.8f;
    public final int xSquares, ySquares;
    public final int squareSize;
    public final Vector2i margins;
    public final GameButton[][] buttons;
    public final int topMarginPx;
    private final GameLogic gameLogic;
    private boolean running = false;
    private final ProgressBar currentSquareBar, gameOverBar;

    public GameScreen(Game game) {
        this(game, GameScreen.recommendedSquareAmount());
    }

    public GameScreen(Game game, Vector2i squareAmount) {
        super(game);
        this.gameLogic = new GameLogic(this);
        this.xSquares = squareAmount.getX();
        this.ySquares = squareAmount.getY();
        Preconditions.checkArgument(this.xSquares > 0 && this.ySquares > 0, "Square count horizontally or vertically cannot be 0 or smaller!");
        final int minMargin = cmToPx(MIN_MARGIN_IN_CM);
        this.squareSize = this.getSquareSize(minMargin);
        this.buttons = new GameButton[xSquares][ySquares];
        this.topMarginPx = (int) (this.height * (1 - TOP_MARGIN_PERCENT));
        this.margins = this.calculateBestMargin();
        Log.debug("Square amount: " + squareAmount);
        this.addComponent(this.currentSquareBar = new ProgressBar(new Rectanglef(-0.5f, -0.95f, -0.95f, -0.05f), 0f, 1f, 1f));
        this.addComponent(this.gameOverBar = new ProgressBar(new Rectanglef(-0.5f, -0.875f, -0.95f, -0.05f), 0f, 1f, 0.5f));

        this.init();
    }

    private static int cmToPx(float cm) {
        return (int) (cm / (1 / Gdx.graphics.getPpcX()));
    }

    private void init() {
        for (int x = 0; x < this.xSquares; x++) {
            for (int y = 0; y < this.ySquares; y++) {
                this.addComponent(this.buttons[x][y] = new GameButton(this, x, y));
            }
        }

    }

    private Vector2i calculateBestMargin() {
        int remainingWidth = this.game.getWidth() - (this.xSquares * this.squareSize);
        int remainingHeight = this.game.getHeight() - (this.ySquares * this.squareSize) - this.topMarginPx;

        return new Vector2i(remainingWidth / (this.xSquares + 1), remainingHeight / (this.ySquares + 1));
    }

    private int getSquareSize(int minMargin) {
        return Math.min(
                (this.game.getWidth() - minMargin * xSquares) / xSquares,
                (this.game.getHeight() - minMargin * ySquares) / ySquares
        );
    }

    public static Vector2i recommendedSquareAmount() {
        return GameScreen.recommendedSquareAmount(Game.INSTANCE.getWidth(), Game.INSTANCE.getHeight());
    }

    public static Vector2i recommendedSquareAmount(int width, int height) {
        int pxAmount = GameScreen.cmToPx(RECOMMENDED_SQUARE_CMS);
        final int minMargin = GameScreen.cmToPx(MIN_MARGIN_IN_CM);
        height -= height * (1 - TOP_MARGIN_PERCENT);
        final int x = (width - minMargin) / (pxAmount + minMargin);
        final int y = (height - minMargin) / (pxAmount + minMargin);
        return new Vector2i(x, y);
    }

    public void start() {
        this.running = true;
        this.gameLogic.init();
    }

    public void stop() {
        this.running = true;
        this.gameLogic.stop();
    }

    public void buttonClicked(int x, int y, GameButton button) {
        Log.log("Button (" + x + ", " + y + ") clicked: " + button.getState() + "!");
        switch (button.getState()) {
            case NORMAL:
                this.gameLogic.normalClicked(x, y);
                break;
            case LIT:
                this.gameLogic.litClicked(x, y);
                break;
            case UPGRADE:
                this.gameLogic.upgradeClicked(x, y);
                break;
        }
    }

    public void setSquareType(int x, int y, GameButton.ButtonState state) {
        this.buttons[x][y].setState(state);
    }

    @Override
    public void onOpening(MyScreen oldScreen) {
        super.onOpening(oldScreen);

        this.game.getProxy().setResizable(false);
    }

    @Override
    public void onClosing(MyScreen newScreen) {
        super.onClosing(newScreen);
        this.running = false;
        this.game.getProxy().setResizable(false);
    }
}
