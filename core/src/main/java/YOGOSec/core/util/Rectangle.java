package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Rectangle<T> extends Vector<T> {

    public T getWidth();

    public Rectangle<T> setWidth(T width);

    public T getHeight();

    public Rectangle<T> setHeight(T height);

    public Rectangle<T> setSize(T width, T height);

    @Override
    public Rectangle<T> setX(T x);

    @Override
    public Rectangle<T> setY(T y);

    public Rectangle<T> setPos(T x, T y);

    public boolean contains(Vector<? extends Number> point, boolean yDown);

    public boolean contains(Vector<? extends Number> point);

    public boolean contains(T px, T py, boolean yDown);

    public boolean contains(T px, T py);

    public Rectangle<T> toPositive();

}
