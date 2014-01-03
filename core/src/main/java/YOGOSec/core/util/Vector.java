package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Vector<T> {

    public T getX();

    public T getY();

    public Vector<T> setX(T x);

    public Vector<T> setY(T y);
}
