package YOGOSec.core.gui;

import YOGOSec.core.render.Render;
import YOGOSec.core.util.Log;
import YOGOSec.core.util.Rectanglef;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ProgressBar extends GUIComponent {

    private static final Color border = Color.BLUE, fill = Color.DARK_GRAY, progressColor = Color.LIGHT_GRAY;
    private static final int MARGIN = 2;
    private final float min, max;
    private Pixmap pixmap;
    private double progress;
    private Texture texture;

    public ProgressBar(Rectanglef bounds, float progress) {
        this(bounds, 0f, 1f, progress);
    }

    public ProgressBar(Rectanglef bounds, float min, float max, float progress) {
        super(bounds);
        if (this.getWidth() < 10) this.setWidth(10f);
        if (this.getHeight() < 10) this.setHeight(10f);
        this.updateBounds();
        this.min = min;
        this.max = max;
        this.progress = (progress + Math.abs(min)) / (max - min);
        this.pixmap = new Pixmap((int) this.getWidth(), (int) this.getHeight(), Pixmap.Format.RGBA8888);
        this.update();
    }

    private void update() {
        if(this.min != -1) Log.debug(this.getBounds());
        this.pixmap.setColor(fill);
        this.pixmap.fillRectangle(MARGIN, MARGIN, (int) (getWidth() - MARGIN * 2), (int) (getHeight() - MARGIN * 2));

        if (progress != 0) {
            this.pixmap.setColor(progressColor);
            this.pixmap.fillRectangle(MARGIN, MARGIN, (int) ((this.getWidth() - MARGIN * 2) * this.progress), (int) (this.getHeight() - MARGIN * 2));
        }

        this.pixmap.setColor(border);
        this.pixmap.fillRectangle(MARGIN, 0, (int) (getWidth() - MARGIN * 2), MARGIN); // Top
        this.pixmap.fillRectangle(0, MARGIN, MARGIN, (int) (getHeight() - MARGIN * 2)); // Left

        this.pixmap.fillRectangle(MARGIN, (int) (getHeight() - MARGIN), (int) (getWidth() - MARGIN * 2), MARGIN); // Bottom
        this.pixmap.fillRectangle((int) (getWidth() - MARGIN), MARGIN, MARGIN, (int) (getHeight() - MARGIN * 2)); // Right

        this.pixmap.drawPixel(1, 1);
        this.pixmap.drawPixel((int) (getWidth() - MARGIN), 1);
        this.pixmap.drawPixel(1, (int) (getHeight() - MARGIN));
        this.pixmap.drawPixel((int) (getWidth() - MARGIN), (int) (getHeight() - MARGIN));

        this.pixmap.drawPixel(MARGIN, MARGIN);
        this.pixmap.drawPixel((int) (getWidth() - 3), MARGIN);
        this.pixmap.drawPixel(MARGIN, (int) (getHeight() - 3));
        this.pixmap.drawPixel((int) (getWidth() - 3), (int) (getHeight() - 3));

        this.texture = new Texture(this.pixmap);
    }

    public void setProgress(double progress) {
        this.progress = (progress + Math.abs(this.min)) / (this.max - this.min);
        this.progress = (this.progress < 0 ? 0 : this.progress > 1 ? 1 : this.progress);
        this.update();
    }

    @Override
    public void render(Render render) {
        render.draw(texture, this.bounds.getX(), this.bounds.getY());
    }

    @Override
    public void onGUIResized(int width, int height) {
        super.onGUIResized(width, height);
        this.pixmap = new Pixmap((int) (this.getWidth()), (int) this.getHeight(), Pixmap.Format.RGBA8888);
        this.update();
    }
}
