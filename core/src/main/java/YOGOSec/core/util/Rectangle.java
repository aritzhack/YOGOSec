package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Rectangle<T> extends Point<T> {

    public T getWidth();

    public T getHeight();

    public Rectangle<T> setWidth(T width);

    public Rectangle<T> setHeight(T height);

    public Rectangle<T> setSize(T width, T height);


    @Override
    public Rectangle<T> setX(T x);

    @Override
    public Rectangle<T> setY(T y);

    public Rectangle<T> setPos(T x, T y);

    public boolean contains(Point<? extends Number> point, boolean yUp);

    public boolean contains(Point<? extends Number> point);

}
