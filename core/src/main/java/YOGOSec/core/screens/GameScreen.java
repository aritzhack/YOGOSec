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

    public static final float MIN_MARGIN_IN_CM = 3f/20f;
    public static final float RECOMMENDED_SQUARE_CMS = 1f;
    public final int xSquares, ySquares;
    public final int squareSize;
    public final Point2i margins;

    public GameScreen(Game game, Point2i squareAmount) {
        super(game);
        this.xSquares = squareAmount.getX();
        this.ySquares = squareAmount.getY();
        final int minMargin = cmToPx(MIN_MARGIN_IN_CM);
        this.squareSize = Math.min((this.game.getWidth() - (xSquares + 1) * minMargin) / xSquares, (this.game.getHeight() - (ySquares + 1) * minMargin) / ySquares);

        this.margins = this.calculateBestMargin();
        this.init();
    }

    private static int cmToPx(float cm) {
        return (int) (cm / (1 / Gdx.graphics.getPpcX()));
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

    private Point2i calculateBestMargin() {
        int remainingWidth = this.game.getWidth() - (this.xSquares * this.squareSize);
        int remainingHeight = this.game.getHeight() - (this.ySquares * this.squareSize);

        return new Point2i(remainingWidth / (this.xSquares + 1), remainingHeight / (this.ySquares + 1));
    }

    public static Point2i recommendedSquareAmount() {
        return GameScreen.recommendedSquareAmount(Game.INSTANCE.getWidth(), Game.INSTANCE.getHeight());
    }

    public static Point2i recommendedSquareAmount(int x, int y) {
        int pxAmount = GameScreen.cmToPx(RECOMMENDED_SQUARE_CMS);
        final int minMargin = GameScreen.cmToPx(MIN_MARGIN_IN_CM);
        return new Point2i((x - minMargin) / (pxAmount + minMargin), (y - minMargin) / (pxAmount + minMargin));
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
