package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Rectanglei implements Rectangle<Integer> {

    private final int x, y;
    private final int width, height;

    public Rectanglei(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectanglei(Point2i p1, Point2i p2) {
        this.x = p1.getX();
        this.y = p1.getY();
        this.width = p2.getX() - p1.getX();
        this.height = p2.getY() - p1.getY();
    }

    @Override
    public Rectanglei setSize(Integer width, Integer height) {
        return new Rectanglei(this.x, this.y, width, height);
    }

    @Override
    public Rectanglei setPos(Integer x, Integer y) {
        return new Rectanglei(x, y, this.width, this.height);
    }

    public Rectanglei translate(int dx, int dy) {
        return new Rectanglei(this.x + dx, this.y + dy, this.width, this.height);
    }

    public Rectanglei scale(float sc, float sy) {
        return new Rectanglei(this.x, this.y, (int) (this.width * sc), (int) (this.height * sy));
    }

    @Override
    public boolean contains(Point<? extends Number> point) {
        return this.contains(point, false);
    }

    @Override
    public boolean contains(Point<? extends Number> point, boolean yUp) {
        return this.contains(point.getX().intValue(), point.getY().intValue(), yUp);
    }

    public boolean contains(int x, int y) {
        return this.contains(x, y, false);
    }

    public boolean contains(int x, int y, boolean yUp) {
        return (!yUp && this.x >= x && this.y >= y && this.x + this.width <= x && this.y + this.height <= y) ||
                this.x >= x && this.y >= y && this.x + this.width <= x && this.y - this.height <= y;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    @Override
    public Rectanglei setX(Integer x) {
        return new Rectanglei(x, this.y, this.width, this.height);
    }

    @Override
    public Rectanglei setY(Integer y) {
        return new Rectanglei(this.x, y, this.width, this.height);
    }

    @Override
    public Rectanglei setWidth(Integer width) {
        return new Rectanglei(this.x, this.y, width, this.height);
    }

    @Override
    public Rectanglei setHeight(Integer height) {
        return new Rectanglei(this.x, this.y, this.width, height);
    }


    @Override
    public String toString() {
        return "(" + this.x + ", " + this.width + ") " + this.width + "x" + this.height;
    }
}
