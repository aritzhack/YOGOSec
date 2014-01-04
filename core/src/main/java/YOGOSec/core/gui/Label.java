package YOGOSec.core.gui;

import YOGOSec.core.render.Render;
import YOGOSec.core.util.Rectanglef;
import YOGOSec.core.util.Vector2f;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Label extends GUIComponent {

    private String text;
    private boolean bigFont;

    public Label(Vector2f point2, String text) {
        this(point2, text, false);
    }

    public Label(Vector2f point2, String text, boolean bigFont) {
        super(new Rectanglef(point2.getX(), point2.getY(), 0f, 0f));
        this.text = text;
        this.bigFont = bigFont;
    }

    public void setBigFont(boolean bigFont) {
        this.bigFont = bigFont;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void render(Render render) {
        super.render(render);
        if (bigFont) {
            if (this.centerX || centerY)
                render.drawBigCenteredString(this.text, (int) this.bounds.getX(), (int) this.bounds.getY());
            else render.drawBigString(this.text, (int) this.bounds.getX(), (int) this.bounds.getY());
        } else {
            if (this.centerX || this.centerY)
                render.drawCenteredString(this.text, (int) this.bounds.getX(), (int) this.bounds.getY());
            else render.drawString(this.text, (int) this.bounds.getX(), (int) this.bounds.getY());
        }
    }
}
