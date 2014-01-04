package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Rectanglef extends AbstractRectangle<Float> {

    public Rectanglef(Float x, Float y, Float width, Float height) {
        super(x, y, width, height);
    }

    @Override
    protected Float abs(Float num1) {
        return Math.abs(num1);
    }

    @Override
    protected boolean positiveOrZero(Float num1) {
        return num1>=0;
    }

    @Override
    protected Float subtract(Float num1, Float num2) {
        return num1-num2;
    }

    @Override
    protected Float add(Float num1, Float num2) {
        return num1 + num2;
    }
}
