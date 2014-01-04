package YOGOSec.core.util;

/**
 * Utility interface that sets what a Rectangle should be like
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Rectangle<T extends Number> extends Vector<T> {

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

    public boolean contains(Vector<? extends T> point, boolean yDown);

    public boolean contains(Vector<? extends T> point);

    public boolean contains(T px, T py, boolean yDown);

    public boolean contains(T px, T py);

    public Rectangle<T> toPositive();

}
