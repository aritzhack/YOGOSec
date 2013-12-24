package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Point {

    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point translate(int dx, int dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isContainedBy(Rectangle rectangle){
        return rectangle.contains(this);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
