package YOGOSec.core.gui;

import YOGOSec.core.render.Render;
import YOGOSec.core.util.Point2f;
import YOGOSec.core.util.Rectanglef;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Label extends GUIComponent {

    private String text;
    private boolean bigFont;

    public Label(Point2f point2, String text) {
        this(point2, text, false);
    }

    public Label(Point2f point2, String text, boolean bigFont) {
        super(new Rectanglef(point2, point2));
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
        if(bigFont) {
            if(this.centerX || centerY) render.drawBigCenteredString(this.text, this.bounds.getX().intValue(), this.bounds.getY().intValue());
            else render.drawBigString(this.text, this.bounds.getX().intValue(), this.bounds.getY().intValue());
        } else {
            if(this.centerX || this.centerY) render.drawCenteredString(this.text, this.bounds.getX().intValue(), this.bounds.getY().intValue());
            else render.drawString(this.text, this.bounds.getX().intValue(), this.bounds.getY().intValue());
        }
    }
}
