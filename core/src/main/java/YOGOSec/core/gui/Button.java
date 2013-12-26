package YOGOSec.core.gui;

import YOGOSec.core.Game;
import YOGOSec.core.render.Render;
import YOGOSec.core.render.YUpPixmap;
import YOGOSec.core.util.Point2i;
import YOGOSec.core.util.Rectanglef;
import com.badlogic.gdx.Gdx;
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
    private YUpPixmap pixmap;
    private Texture texture;

    public Button(Rectanglef bounds, String text, IActionListener listener) {
        super(bounds);
        this.text = text;
        this.listener = listener;

        this.pixmap = new YUpPixmap(Game.INSTANCE.getRender().getWidth(), Game.INSTANCE.getRender().getHeight(), Pixmap.Format.RGBA8888);

        pixmap.setColor(Color.RED);
        pixmap.fillRectangle(this.bounds.getX().intValue(), this.bounds.getY().intValue(), this.bounds.getWidth().intValue(), this.bounds.getHeight().intValue());
        pixmap.setColor(Color.BLACK);
        Gdx.app.log("YOGOSec", "Created button: " + this.bounds);
        this.texture = new Texture(this.pixmap);
    }

    @Override
    public void render(Render render) {
        super.render(render);
        render.draw(this.texture, 0, 0);
        render.drawBigCenteredString(this.text, (int) (this.bounds.getX() + (this.bounds.getWidth() / 2)), (int) (this.bounds.getY() + (this.bounds.getHeight() / 2)));
    }

    @Override
    public boolean touchDown(Point2i point, int pointer, int button) {
        Gdx.app.log("YOGOSec", "Touched at: " + point);
        if (this.bounds.contains(point, true)) {
            Gdx.app.log("YOGOSec", "Touched down!");
            this.pressed = true;
            this.pressPointer = pointer;
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(Point2i point, int pointer, int button) {
        if (this.bounds.contains(point, true)) {
            this.pressed = false;
            this.hovered = false;
            Gdx.app.debug("YOGOSec", "Clicked with text: " + this.text);
            if (this.listener != null) listener.actionPerformed(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged(Point2i point, int pointer) {
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
    public boolean mouseMoved(Point2i point) {
        return this.hovered = this.bounds.contains(point);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.pixmap.dispose();
        this.texture.dispose();
    }

    @Override
    public void onGUIResized(int width, int height) {
        super.onGUIResized(width, height);
        this.pixmap.dispose();
        this.pixmap = new YUpPixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.RED);
        pixmap.fillRectangle(this.bounds.getX().intValue(), this.bounds.getY().intValue(), this.bounds.getWidth().intValue(), this.bounds.getHeight().intValue());
        pixmap.setColor(Color.BLACK);
    }
}
