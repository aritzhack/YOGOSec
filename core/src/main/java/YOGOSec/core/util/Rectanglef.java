package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Rectanglef {

    private final float x;
    private final float y;
    private final float width;
    private final float height;

    public Rectanglef(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return this.width;
    }

    
    public Rectanglef setWidth(float width) {
        return new Rectanglef(this.x, this.y, width, this.height);
    }

    
    public float getHeight() {
        return this.height;
    }

    
    public Rectanglef setHeight(float height) {
        return new Rectanglef(this.x, this.y, this.width, height);
    }

    
    public Rectanglef setSize(float width, float height) {
        return new Rectanglef(this.x, this.y, width, height);
    }

    
    public Rectanglef setX(float x) {
        return new Rectanglef(x, this.y, this.width, this.height);
    }

    
    public Rectanglef setY(float y) {
        return new Rectanglef(this.x, y, this.width, this.height);
    }

    
    public Rectanglef setPos(float x, float y) {
        return new Rectanglef(x, y, this.width, this.height);
    }

    
    public boolean contains(Vector2f point, boolean yDown) {
        return this.contains(point.getX(), point.getY(), yDown);
    }

    
    public boolean contains(Vector2f point) {
        return this.contains(point, false);
    }

    
    public boolean contains(float px, float py, boolean yDown) {
        return px >= this.x && px <= this.x + this.width && py>=this.y && ((!yDown && py<=this.y+this.height) || (yDown && py>=this.y + this.height));
    }

    
    public boolean contains(float px, float py) {
        return this.contains(px, py, false);
    }

    
    public Rectanglef toPositive() {
        return new Rectanglef(Math.abs(this.x), Math.abs(this.y), Math.abs(this.width), Math.abs(this.height));
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }
}
