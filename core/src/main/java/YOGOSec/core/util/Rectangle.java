package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Rectangle {

    private final int x, y;
    private final int width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point p1, Point p2) {
        this.x = p1.getX();
        this.y = p1.getY();
        this.width = p2.getX() - p1.getX();
        this.height = p2.getY() - p1.getY();
    }

    public Rectangle setSize(int width, int height) {
        return new Rectangle(this.x, this.y, width, height);
    }

    public Rectangle setPosition(int x, int y) {
        return new Rectangle(x, y, this.width, this.height);
    }

    public Rectangle translate(int dx, int dy) {
        return new Rectangle(this.x + dx, this.y + dy, this.width, this.height);
    }

    public Rectangle scale(float sc, float sy) {
        return new Rectangle(this.x, this.y, (int) (this.width * sc), (int) (this.height * sy));
    }

    public boolean contains(Point point) {
        return this.contains(point.getX(), point.getY());
    }

    public boolean contains(int x, int y) {
        return this.x >= x && this.y >= y && this.x + this.width <= x && this.y + this.height <= y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public Rectangle setX(int x){
        return new Rectangle(x, this.y, this.width, this.height);
    }

    public Rectangle setY(int y){
        return new Rectangle(this.x, y, this.width, this.height);
    }

}
