package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Vector2f implements Vector<Float> {

    public static final Vector2f ORIGIN = new Vector2f(0, 0);
    private final float x, y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f translate(float dx, float dy) {
        return new Vector2f(this.x + dx, this.y + dy);
    }

    public Float getY() {
        return y;
    }

    public Float getX() {
        return x;
    }

    @Override
    public Vector2f setX(Float x) {
        return new Vector2f(x, this.y);
    }

    @Override
    public Vector2f setY(Float y) {
        return new Vector2f(this.x, y);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
