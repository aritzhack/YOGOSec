package YOGOSec.core.render;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;

/**
 * A subclass of the Pixmap class that uses a Y-Up coordinate system (i.e. the origin or (0, 0) is in the bottom left).
 *
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class YUpPixmap extends Pixmap {

    /**
     * Creates a new Pixmap instance with the given width, height and format.
     *
     * @param width  the width in pixels.
     * @param height the height in pixels.
     * @param format the {@link com.badlogic.gdx.graphics.Pixmap.Format}.
     */
    public YUpPixmap(int width, int height, Format format) {
        super(width, height, format);
    }

    /**
     * Creates a new Pixmap instance from the given encoded image data. The image can be encoded as JPEG, PNG or BMP.
     *
     * @param encodedData the encoded image data.
     * @param offset      the offset.
     * @param len         the length
     */
    public YUpPixmap(byte[] encodedData, int offset, int len) {
        super(encodedData, offset, len);
    }

    /**
     * Creates a new Pixmap instance from the given file. The file must be a Png, Jpeg or Bitmap. Paletted formats are not
     * supported.
     *
     * @param file the {@link com.badlogic.gdx.files.FileHandle}.
     */
    public YUpPixmap(FileHandle file) {
        super(file);
    }

    /**
     * Constructs a new Pixmap from a {@link com.badlogic.gdx.graphics.g2d.Gdx2DPixmap}.
     *
     * @param pixmap The Gdx2DPixmap to construct this one from
     */
    public YUpPixmap(Gdx2DPixmap pixmap) {
        super(pixmap);
    }

    /**
     * Draws a line between the given coordinates using the currently set color.
     *
     * @param x  The x-coodinate of the first point.
     * @param y  The y-coordinate of the first point.
     * @param x2 The x-coordinate of the first point.
     * @param y2 The y-coordinate of the first point.
     */
    @Override
    public void drawLine(int x, int y, int x2, int y2) {
        super.drawLine(x, this.getHeight() - y, x2, this.getHeight() - y2);
    }

    /**
     * Draws a rectangle outline starting at x, y extending by width to the right and by height upwards (y-axis points upwards)
     * using the current color.
     *
     * @param x      The x coordinate.
     * @param y      The y coordinate.
     * @param width  The width in pixels.
     * @param height The height in pixels.
     */
    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        super.drawRectangle(x, this.getHeight() - y - height, width, height);
    }

    /**
     * Fills a rectangle starting at x, y extending by width to the right and by height upwards (y-axis points upwards) using
     * the current color.
     *
     * @param x      The x coordinate.
     * @param y      The y coordinate.
     * @param width  The width in pixels.
     * @param height The height in pixels.
     */
    @Override
    public void fillRectangle(int x, int y, int width, int height) {
        super.fillRectangle(x, this.getHeight() - y - height, width, height);
    }

    /**
     * Draws a circle outline with the center at x,y and a radius using the current color and stroke width.
     *
     * @param x      The x-coordinate of the center.
     * @param y      The y-coordinate of the center.
     * @param radius The radius in pixels.
     */
    @Override
    public void drawCircle(int x, int y, int radius) {
        super.drawCircle(x, this.getHeight() - y, radius);
    }

    /**
     * Fills a circle with the center at x,y and a radius using the current color.
     *
     * @param x      The x-coordinate of the center.
     * @param y      The y-coordinate of the center.
     * @param radius The radius in pixels.
     */
    @Override
    public void fillCircle(int x, int y, int radius) {
        super.fillCircle(x, this.getHeight() - y, radius);
    }

    /**
     * Fills a triangle with vertices at x1,y1 and x2,y2 and x3,y3 using the current color.
     *
     * @param x1 The x-coordinate of vertex 1.
     * @param y1 The y-coordinate of vertex 1.
     * @param x2 The x-coordinate of vertex 2.
     * @param y2 The y-coordinate of vertex 2.
     * @param x3 The x-coordinate of vertex 3.
     * @param y3 The y-coordinate of vertex 3.
     */
    @Override
    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        super.fillTriangle(x1, this.getHeight() - y1, x2, this.getHeight() - y2, x3, this.getHeight() - y3);
    }

    /**
     * Returns the 32-bit RGBA8888 value of the pixel at x, y. For Alpha formats the RGB components will be one.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @return The pixel color in RGBA8888 format.
     */
    @Override
    public int getPixel(int x, int y) {
        return super.getPixel(x, this.getHeight() - y);
    }

    /**
     * Draws a pixel at the given location with the current color.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     */
    @Override
    public void drawPixel(int x, int y) {
        super.drawPixel(x, this.getHeight() - y);
    }

    /**
     * Draws a pixel at the given location with the given color.
     *
     * @param x     the x-coordinate.
     * @param y     the y-coordinate.
     * @param color the color in RGBA8888 format.
     */
    @Override
    public void drawPixel(int x, int y, int color) {
        super.drawPixel(x, this.getHeight() - y, color);
    }
}
