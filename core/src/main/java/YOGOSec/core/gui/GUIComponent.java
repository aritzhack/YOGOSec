package YOGOSec.core.gui;

import YOGOSec.core.Game;
import YOGOSec.core.render.Render;
import YOGOSec.core.util.Point2i;
import YOGOSec.core.util.Rectangle;
import YOGOSec.core.util.Rectanglef;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class GUIComponent implements InputListener {

    protected final boolean centerX, centerY, relativeWidth, relativeHeight, absolute;
    protected Rectangle<Float> relativeBounds;
    protected Rectangle<Float> bounds;

    public GUIComponent(Rectanglef bounds) {
        this.relativeBounds = bounds;

        this.centerX = this.relativeBounds.getX() < 0;
        this.centerY = this.relativeBounds.getY() < 0;
        this.relativeWidth = this.relativeBounds.getWidth() < 0;
        this.relativeHeight = this.relativeBounds.getHeight() < 0;

        this.absolute = !(centerX || centerY || relativeWidth || relativeHeight);


        this.relativeBounds = this.relativeBounds.setPos(Math.abs(this.relativeBounds.getX()), Math.abs(this.relativeBounds.getY()));
        this.relativeBounds = this.relativeBounds.setSize(Math.abs(this.relativeBounds.getWidth()), Math.abs(this.relativeBounds.getHeight()));
        this.updateBounds();
    }

    protected void updateBounds() {
        if (this.absolute) {
            if (this.bounds == null) this.bounds = this.relativeBounds;
            return;
        }

        final int gameWidth = Game.INSTANCE.getRender().getWidth();
        final int gameHeight = Game.INSTANCE.getRender().getHeight();

        float width = this.relativeBounds.getWidth() * (this.relativeWidth ? gameWidth : 1);
        float height = this.relativeBounds.getHeight() * (this.relativeHeight ? gameHeight : 1);

        float x = gameWidth * this.relativeBounds.getX() - (this.centerX ? width / 2 : 0);
        float y = gameHeight * this.relativeBounds.getY() - (this.centerY ? height / 2 : 0);

        this.bounds = new Rectanglef(x, y, width, height);
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
    public boolean touchDown(Point2i point, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(Point2i point, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(Point2i point, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(Point2i point) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public Rectangle<Float> getBounds() {
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
