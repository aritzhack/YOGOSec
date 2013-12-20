package YOGOSec.core.render;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ProgressBar {

    private static final Color border = Color.BLUE, fill = Color.DARK_GRAY, progressColor = Color.LIGHT_GRAY;
    private static boolean loaded;
    private final int x, y, width, height;
    private final float min, max;
    private final Pixmap pixmap;
    private float progress;
    private Texture texture;
    private static final int MARGIN = 2;

    public ProgressBar(int x, int y, int width, int height, float progress) {
        this(x, y, width, height, 0f, 1f, progress);
    }

    public ProgressBar(int x, int y, int width, int height, float min, float max, float progress) {
        if (width < 10) width = 10;
        if (height < 10) height = 10;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.min = min;
        this.max = max;
        this.progress = progress;
        this.pixmap = new Pixmap(this.width, this.height, Pixmap.Format.RGBA8888);
        this.update();
    }

    private void update() {

        this.pixmap.setColor(fill);
        this.pixmap.fillRectangle(MARGIN, MARGIN, this.width - MARGIN*2, this.height - MARGIN*2);

        if (progress != 0) {
            this.pixmap.setColor(progressColor);
            this.pixmap.fillRectangle(MARGIN, MARGIN, (int) ((this.width - MARGIN*2) * this.progress), this.height - MARGIN*2);
        }

        this.pixmap.setColor(border);
        this.pixmap.fillRectangle(MARGIN, 0, this.width - MARGIN*2, MARGIN); // Top
        this.pixmap.fillRectangle(0, MARGIN, MARGIN, this.height - MARGIN*2); // Left

        this.pixmap.fillRectangle(2, this.height - 2, this.width - MARGIN*2, MARGIN); // Bottom
        this.pixmap.fillRectangle(this.width - MARGIN, MARGIN, MARGIN, this.height - MARGIN*2); // Right

        this.pixmap.drawPixel(1, 1);
        this.pixmap.drawPixel(this.width - 2, 1);
        this.pixmap.drawPixel(1, this.height - 2);
        this.pixmap.drawPixel(this.width - 2, this.height - 2);

        this.pixmap.drawPixel(2, 2);
        this.pixmap.drawPixel(this.width - 3, 2);
        this.pixmap.drawPixel(2, this.height - 3);
        this.pixmap.drawPixel(this.width - 3, this.height - 3);

        this.texture = new Texture(this.pixmap);
    }

    public void setProgress(float progress) {
        this.progress = (progress < 0 ? 0 : progress > 1 ? 1 : progress);
        this.update();
    }

    public void draw(Render render) {
        render.draw(texture, x, y);
    }
}
