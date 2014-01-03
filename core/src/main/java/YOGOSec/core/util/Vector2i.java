package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Vector2i implements Vector<Integer> {

    public static final Vector2i ORIGIN = new Vector2i(0, 0);
    private final int x, y;

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2i translate(int dx, int dy) {
        return new Vector2i(this.x + dx, this.y + dy);
    }

    public Integer getY() {
        return y;
    }

    @Override
    public Vector2i setX(Integer x) {
        return new Vector2i(x, this.y);
    }

    @Override
    public Vector2i setY(Integer y) {
        return new Vector2i(this.x, y);
    }

    public Integer getX() {
        return x;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
