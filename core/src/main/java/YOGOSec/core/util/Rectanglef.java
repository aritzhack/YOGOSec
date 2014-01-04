package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Rectanglef implements Rectangle<Float> {

    private final float x, y;
    private final float width, height;

    public Rectanglef(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectanglef(Vector2f p1, Vector2f p2) {
        this.x = p1.getX();
        this.y = p1.getY();
        this.width = p2.getX() - p1.getX();
        this.height = p2.getY() - p1.getY();
    }

    public Rectanglef setSize(float width, float height) {
        return new Rectanglef(this.x, this.y, width, height);
    }

    public Rectanglef translate(int dx, int dy) {
        return new Rectanglef(this.x + dx, this.y + dy, this.width, this.height);
    }

    public Rectanglef scale(float sc, float sy) {
        return new Rectanglef(this.x, this.y, (int) (this.width * sc), (int) (this.height * sy));
    }

    public Float getX() {
        return x;
    }

    @Override
    public Rectanglef setX(Float x) {
        return new Rectanglef(x, this.y, this.width, this.height);
    }

    public Float getY() {
        return y;
    }

    @Override
    public Rectanglef setY(Float y) {
        return new Rectanglef(this.x, y, this.width, this.height);
    }

    @Override
    public Rectanglef setPos(Float x, Float y) {
        return new Rectanglef(x, y, this.width, this.height);
    }

    @Override
    public boolean contains(Vector<? extends Float> point, boolean yUp) {
        return this.contains(point.getX(), point.getY(), yUp);
    }

    @Override
    public boolean contains(Vector<? extends Float> point) {
        return this.contains(point, false);
    }

    @Override
    public boolean contains(Float px, Float py, boolean yDown) {
        return (!yDown && px >= this.x && py >= this.y && px <= this.x + this.width && py <= this.y + this.height) ||
                (yDown && px >= this.x && py >= y + height && px <= this.x + this.width && py <= y);
    }

    @Override
    public boolean contains(Float x, Float y) {
        return this.contains(x, y, false);
    }

    @Override
    public Rectangle<Float> toPositive() {
        return new Rectanglef(Math.abs(this.getX()), Math.abs(this.getY()), Math.abs(this.getWidth()), Math.abs(this.getHeight()));
    }

    public Float getWidth() {
        return width;
    }

    @Override
    public Rectanglef setWidth(Float width) {
        return new Rectanglef(this.x, this.y, width, this.height);
    }

    public Float getHeight() {
        return height;
    }

    @Override
    public Rectanglef setHeight(Float height) {
        return new Rectanglef(this.x, this.y, this.width, height);
    }

    @Override
    public Rectanglef setSize(Float width, Float height) {
        return new Rectanglef(this.x, this.y, width, height);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ") " + this.width + "x" + this.height;
    }
}
