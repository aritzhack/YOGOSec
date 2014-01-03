package YOGOSec.core.util;

import YOGOSec.core.screens.GameScreen;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameLogic {

    public static final int UPGRADE_EXTRA_TIME = 1000;
    public boolean dead;
    private long pausedDiff = -1, currentMax = 1000, currentTime, millisLeft;
    private int gameOverCountdown = 60;
    private int gameOverCountdownMax = 60;
    private boolean paused;

    public GameLogic(GameScreen screen) {

    }

    public void init() {
        this.currentTime = System.currentTimeMillis() + this.currentMax;
    }

    public void update() {
        if (this.paused) return;
        this.millisLeft = this.currentTime - System.currentTimeMillis();

        if (this.millisLeft <= 0) {
            this.millisLeft = 0;
            if (!this.dead) this.gameOver();
        }
    }

    private void gameOver() {

    }

    public void pause() {
        this.paused = true;
        this.pausedDiff = millisLeft;
    }

    public void resume() {

    }

    public void normalClicked(int x, int y) {

    }

    public void litClicked(int x, int y) {

    }

    public void upgradeClicked(int x, int y) {

    }

    public void stop() {

    }
}
