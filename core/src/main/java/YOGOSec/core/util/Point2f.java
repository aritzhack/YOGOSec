package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Point2f implements Point<Float> {

    private final float x, y;

    public Point2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2f translate(float dx, float dy) {
        return new Point2f(this.x + dx, this.y + dy);
    }

    public Float getY() {
        return y;
    }

    public Float getX() {
        return x;
    }

    @Override
    public Point2f setX(Float x) {
        return new Point2f(x, this.y);
    }

    @Override
    public Point2f setY(Float y) {
        return new Point2f(this.x, y);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
