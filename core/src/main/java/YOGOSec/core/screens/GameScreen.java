package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.GameButton;
import YOGOSec.core.util.Log;
import YOGOSec.core.util.Point2i;
import com.badlogic.gdx.Gdx;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameScreen extends MyScreen {

    public static final int MIN_MARGIN = 10;
    public static final float RECOMMENDED_SQUARE_CMS = 1f / 1f;
    public final int xSquares, ySquares;
    public final int SQUARE_SIZE;
    public int xMargin, yMargin;

    public GameScreen(Game game, Point2i squareAmount) {
        super(game);
        this.xSquares = squareAmount.getX();
        this.ySquares = squareAmount.getY();
        this.SQUARE_SIZE = Math.min((this.game.getWidth() - (xSquares + 1) * MIN_MARGIN) / xSquares, (this.game.getHeight() - (ySquares + 1) * MIN_MARGIN) / ySquares);

        this.calculateBestMargin();
        this.init();
    }

    public GameScreen(Game game) {
        this(game, GameScreen.recommendedSquareAmount());
    }

    private void init() {
        for (int x = 0; x < this.xSquares; x++) {
            for (int y = 0; y < this.ySquares; y++) {
                this.addComponent(new GameButton(this, x, y));
            }
        }
    }

    private void calculateBestMargin() {
        int remainingWidth = this.game.getWidth() - (this.xSquares * this.SQUARE_SIZE);
        int remainingHeight = this.game.getHeight() - (this.ySquares * this.SQUARE_SIZE);

        this.xMargin = remainingWidth / (xSquares + 1);
        this.yMargin = remainingHeight / (ySquares + 1);
    }

    public static Point2i recommendedSquareAmount() {
        return GameScreen.recommendedSquareAmount(Game.INSTANCE.getWidth(), Game.INSTANCE.getHeight());
    }

    public static Point2i recommendedSquareAmount(int x, int y) {
        int pxAmount = (int) (RECOMMENDED_SQUARE_CMS / (1 / Gdx.graphics.getPpcX()));
        return new Point2i((x - MIN_MARGIN) / (pxAmount + MIN_MARGIN), (y - MIN_MARGIN) / (pxAmount + MIN_MARGIN));
    }

    public void start() {

    }

    public void stop() {

    }

    public void buttonClicked(int x, int y, GameButton.ButtonState state) {
        Log.log("Button (" + x + ", " + y + ") clicked: " + state + "!");
    }

    @Override
    public void onOpening(MyScreen oldScreen) {
        super.onOpening(oldScreen);

        this.game.getProxy().setResizable(false);
    }

    @Override
    public void onClosing(MyScreen newScreen) {
        super.onClosing(newScreen);

        this.game.getProxy().setResizable(false);
    }
}
