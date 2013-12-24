package YOGOSec.core.gui;

import YOGOSec.core.Game;
import YOGOSec.core.render.Render;
import YOGOSec.core.util.Point;
import YOGOSec.core.util.Rectangle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Button extends GUIComponent {

    private final String text;
    private final IActionListener listener;
    private boolean pressed, hovered;
    private int pressPointer = -1;
    private Pixmap pixmap;

    public Button(Rectangle bounds, String text, IActionListener listener) {
        super(bounds);
        this.text = text;
        this.listener = listener;

        if (this.bounds.getX() == -1) {
            this.bounds = this.bounds.setX((Game.INSTANCE.getWidth() / 2) - (this.bounds.getWidth() / 2));
        }
        if (this.bounds.getY() == -1) {
            this.bounds = this.bounds.setY((Game.INSTANCE.getHeight() / 2) - (this.bounds.getHeight() / 2));
        }
        this.pixmap = new Pixmap(this.bounds.getWidth(), this.bounds.getHeight(), Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.RED);
        pixmap.fillRectangle(0, 0, this.bounds.getWidth(), this.bounds.getHeight());
        pixmap.setColor(Color.BLACK);
        pixmap.drawPixel(this.bounds.getX() + (this.bounds.getWidth() / 2), this.bounds.getY() + (this.bounds.getHeight() / 2));
        pixmap.drawPixel(pixmap.getWidth() / 2, pixmap.getHeight() / 2);
    }

    @Override
    public void render(Render render) {
        super.render(render);
        render.draw(new Texture(pixmap), this.bounds.getX(), this.bounds.getY());
        render.drawBigCenteredString(this.text, this.bounds.getX() + (this.bounds.getWidth() / 2), this.bounds.getY() + (this.bounds.getHeight() / 2));
    }

    @Override
    public boolean touchDown(Point point, int pointer, int button) {
        if (this.bounds.contains(point)) {
            this.pressed = true;
            this.pressPointer = pointer;
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(Point point, int pointer, int button) {
        if (this.bounds.contains(point)) {
            this.pressed = false;
            this.hovered = false;
            if (this.listener != null) listener.actionPerformed(this);
            System.out.println("Clicked with text: " + this.text);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged(Point point, int pointer) {
        if (pointer == this.pressPointer && !this.bounds.contains(point)) {
            this.hovered = false;
            this.pressed = false;
        } else if (this.bounds.contains(point)) {
            this.pressed = true;
            this.pressPointer = pointer;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(Point point) {
        return this.hovered = this.bounds.contains(point);
    }
}
