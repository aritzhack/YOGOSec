package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Point2i implements Point<Integer> {

    public static final Point2i ORIGIN = new Point2i(0, 0);
    private final int x, y;

    public Point2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2i translate(int dx, int dy) {
        return new Point2i(this.x + dx, this.y + dy);
    }

    public Integer getY() {
        return y;
    }

    @Override
    public Point2i setX(Integer x) {
        return new Point2i(x, this.y);
    }

    @Override
    public Point2i setY(Integer y) {
        return new Point2i(this.x, y);
    }

    public Integer getX() {
        return x;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
