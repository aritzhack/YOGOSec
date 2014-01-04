package YOGOSec.core.gui;

import YOGOSec.core.Game;
import YOGOSec.core.render.Render;
import YOGOSec.core.util.Rectanglef;
import YOGOSec.core.util.Vector2f;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class GUIComponent implements InputListener {

    protected final boolean centerX, centerY, relativeWidth, relativeHeight, absolute;
    private Rectanglef relativeBounds;
    protected Rectanglef bounds;

    public GUIComponent(Rectanglef bounds) {
        this.relativeBounds = bounds;

        this.centerX = bounds.getX() < 0;
        this.centerY = bounds.getY() < 0;
        this.relativeWidth = bounds.getWidth() < 0;
        this.relativeHeight = bounds.getHeight() < 0;

        this.absolute = !(centerX || centerY || relativeWidth || relativeHeight);

        if (!this.absolute) this.relativeBounds = bounds.toPositive();
        else this.relativeBounds = bounds;

        this.updateBounds();
    }

    protected void updateBounds() {
        if (this.absolute) {
            this.bounds = this.relativeBounds;
        } else {
            final int gameWidth = Game.INSTANCE.getRender().getWidth();
            final int gameHeight = Game.INSTANCE.getRender().getHeight();

            float width = this.relativeBounds.getWidth() * (this.relativeWidth ? gameWidth : 1);
            float height = this.relativeBounds.getHeight() * (this.relativeHeight ? gameHeight : 1);

            float x = gameWidth * this.relativeBounds.getX() - (this.centerX ? width / 2 : 0);
            float y = gameHeight * this.relativeBounds.getY() - (this.centerY ? height / 2 : 0);

            this.bounds = new Rectanglef(x, y, width, height);
        }
    }

    public void render(Render render) {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(Vector2f point, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(Vector2f point, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(Vector2f point, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(Vector2f point) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public Rectanglef getBounds() {
        return this.bounds;
    }

    public void onGUIResized(int width, int height) {
        this.updateBounds();
    }

    public float getWidth() {
        return this.bounds.getWidth();
    }

    public void setWidth(float width) {
        this.relativeBounds = this.relativeBounds.setWidth(width);
    }

    public float getHeight() {
        return this.bounds.getHeight();
    }

    public void setHeight(float height) {
        this.relativeBounds = this.relativeBounds.setHeight(height);
    }

    public void dispose() {

    }
}
