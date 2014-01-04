package YOGOSec.core.util;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AbstractRectangle<T extends Number> implements Rectangle<T> {

    private final T x, y;
    private final T width, height;

    public AbstractRectangle(T x, T y, T width, T height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public T getWidth() {
        return this.width;
    }

    @Override
    public Rectangle<T> setWidth(T width) {
        return new ImplRectangle(this.x, this.y, width, this.height);
    }

    @Override
    public T getHeight() {
        return this.height;
    }

    @Override
    public Rectangle<T> setHeight(T height) {
        return new ImplRectangle(this.x, this.y, this.width, height);
    }

    @Override
    public Rectangle<T> setSize(T width, T height) {
        return new ImplRectangle(this.x, this.y, width, height);
    }

    @Override
    public Rectangle<T> setX(T x) {
        return new ImplRectangle(x, this.y, this.width, this.height);
    }

    @Override
    public Rectangle<T> setY(T y) {
        return new ImplRectangle(this.x, y, this.width, this.height);
    }

    @Override
    public Rectangle<T> setPos(T x, T y) {
        return new ImplRectangle(x, y, this.width, this.height);
    }

    @Override
    public boolean contains(Vector<? extends T> point, boolean yDown) {
        return this.contains(point.getX(), point.getY(), yDown);
    }

    @Override
    public boolean contains(Vector<? extends T> point) {
        return this.contains(point, false);
    }

    @Override
    public boolean contains(T px, T py, boolean yDown) {
        return
                this.positiveOrZero(this.subtract(px, this.x)) &&
                        this.positiveOrZero(this.subtract(py, this.y)) &&
                        this.positiveOrZero(this.subtract(this.add(this.x, this.width), px)) &&
                        (
                                (!yDown && this.positiveOrZero(this.subtract(this.add(this.y, this.height), py)) ||
                                        (yDown && this.positiveOrZero(this.subtract(py, this.add(this.y, this.height))))
                                )
                        );
    }

    @Override
    public boolean contains(T px, T py) {
        return this.contains(px, py, false);
    }

    @Override
    public Rectangle<T> toPositive() {
        return new ImplRectangle(this.abs(this.x), this.abs(this.y), this.abs(this.width), this.abs(this.height));
    }

    protected abstract T abs(T num1);

    protected abstract boolean positiveOrZero(T num1);

    protected abstract T subtract(T num1, T num2);

    protected abstract T add(T num1, T num2);

    @Override
    public T getX() {
        return this.x;
    }

    @Override
    public T getY() {
        return this.y;
    }

    private class ImplRectangle extends AbstractRectangle<T> {
        public ImplRectangle(T x, T y, T width, T height) {
            super(x, y, width, height);
        }

        @Override
        protected T add(T num1, T num2) {
            return AbstractRectangle.this.add(num1, num2);
        }

        @Override
        protected T subtract(T num1, T num2) {
            return AbstractRectangle.this.subtract(num1, num2);
        }

        @Override
        protected boolean positiveOrZero(T num1) {
            return AbstractRectangle.this.positiveOrZero(num1);
        }

        @Override
        protected T abs(T num1) {
            return AbstractRectangle.this.abs(num1);
        }


    }


}
