package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Rectanglei extends AbstractRectangle<Integer> {

    public Rectanglei(Integer x, Integer y, Integer width, Integer height) {
        super(x, y, width, height);
    }

    @Override
    protected Integer abs(Integer num1) {
        return Math.abs(num1);
    }

    @Override
    protected boolean positiveOrZero(Integer num1) {
        return num1>=0;
    }

    @Override
    protected Integer subtract(Integer num1, Integer num2) {
        return num1-num2;
    }

    @Override
    protected Integer add(Integer num1, Integer num2) {
        return num1+num2;
    }
}
