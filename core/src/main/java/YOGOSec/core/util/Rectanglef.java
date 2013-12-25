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

    public Rectanglef(Point2f p1, Point2f p2) {
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

    public boolean contains(float x, float y) {
        return this.contains(x, y, false);
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
    public Rectanglef setSize(Float width, Float height) {
        return new Rectanglef(this.x, this.y, width, height);
    }

    public boolean contains(Point<? extends Number> point, boolean yUp) {
        return this.contains(point.getX().floatValue(), point.getY().floatValue(), yUp);
    }

    public boolean contains(float x, float y, boolean yUp) {
        return (!yUp && this.x >= x && this.y >= y && this.x + this.width <= x && this.y + this.height <= y) ||
                this.x >= x && this.y >= y && this.x + this.width <= x && this.y - this.height <= y;
    }

    public boolean contains(Point<? extends Number> point) {
        return this.contains(point, false);
    }

    public Float getWidth() {
        return width;
    }

    @Override
    public Rectanglef setWidth(Float width) {
        return new Rectanglef(this.x, this.y, width, this.height);
    }

    @Override
    public Rectanglef setHeight(Float height) {
        return new Rectanglef(this.x, this.y, this.width, height);
    }

    public Float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.width + ") " + this.width + "x" + this.height;
    }
}
