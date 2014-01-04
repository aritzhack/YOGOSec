package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Rectanglei {

    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Rectanglei(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }


    public Rectanglei setWidth(int width) {
        return new Rectanglei(this.x, this.y, width, this.height);
    }


    public int getHeight() {
        return this.height;
    }


    public Rectanglei setHeight(int height) {
        return new Rectanglei(this.x, this.y, this.width, height);
    }


    public Rectanglei setSize(int width, int height) {
        return new Rectanglei(this.x, this.y, width, height);
    }


    public Rectanglei setX(int x) {
        return new Rectanglei(x, this.y, this.width, this.height);
    }


    public Rectanglei setY(int y) {
        return new Rectanglei(this.x, y, this.width, this.height);
    }


    public Rectanglei setPos(int x, int y) {
        return new Rectanglei(x, y, this.width, this.height);
    }


    public boolean contains(Vector2i point, boolean yDown) {
        return this.contains(point.getX(), point.getY(), yDown);
    }


    public boolean contains(Vector2i point) {
        return this.contains(point, false);
    }


    public boolean contains(int px, int py, boolean yDown) {
        return px >= this.x && px <= this.x + this.width && py>=this.y && ((!yDown && py<=this.y+this.height) || (yDown && py>=this.y + this.height));
    }


    public boolean contains(int px, int py) {
        return this.contains(px, py, false);
    }


    public Rectanglei toPositive() {
        return new Rectanglei(Math.abs(this.x), Math.abs(this.y), Math.abs(this.width), Math.abs(this.height));
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
