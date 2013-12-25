package YOGOSec.core.render;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class YUpPixmap extends Pixmap {

    public YUpPixmap(int width, int height, Format format) {
        super(width, height, format);
    }

    public YUpPixmap(byte[] encodedData, int offset, int len) {
        super(encodedData, offset, len);
    }

    public YUpPixmap(FileHandle file) {
        super(file);
    }

    public YUpPixmap(Gdx2DPixmap pixmap) {
        super(pixmap);
    }

    @Override
    public void drawLine(int x, int y, int x2, int y2) {
        super.drawLine(x, this.getHeight() - y, x2, this.getHeight() - y2);
    }

    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        super.drawRectangle(x, this.getHeight() - y - height, width, height);
    }

    @Override
    public void fillRectangle(int x, int y, int width, int height) {
        super.fillRectangle(x, this.getHeight() - y - height, width, height);
    }

    @Override
    public void drawCircle(int x, int y, int radius) {
        super.drawCircle(x, this.getHeight() - y, radius);
    }

    @Override
    public void fillCircle(int x, int y, int radius) {
        super.fillCircle(x, this.getHeight() - y, radius);
    }

    @Override
    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        super.fillTriangle(x1, this.getHeight() - y1, x2, this.getHeight() - y2, x3, this.getHeight() - y3);
    }

    @Override
    public int getPixel(int x, int y) {
        return super.getPixel(x, this.getHeight() - y);
    }

    @Override
    public void drawPixel(int x, int y) {
        super.drawPixel(x, this.getHeight() - y);
    }

    @Override
    public void drawPixel(int x, int y, int color) {
        super.drawPixel(x, this.getHeight() - y, color);
    }
}
