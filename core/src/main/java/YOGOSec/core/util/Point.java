package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Point<T> {

    public T getX();

    public T getY();

    public Point<T> setX(T x);

    public Point<T> setY(T y);
}
