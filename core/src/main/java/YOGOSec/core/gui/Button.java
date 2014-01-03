package YOGOSec.core.gui;

import YOGOSec.core.Game;
import YOGOSec.core.render.Render;
import YOGOSec.core.util.Vector2i;
import YOGOSec.core.util.Rectanglef;
import YOGOSec.core.util.Util;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.google.common.base.Strings;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Button extends GUIComponent {

    private final String text;
    private final IActionListener listener;
    private boolean pressed, hovered;
    private int pressPointer = -1;
    private Texture textureNormal, textureHovered, texturePressed;

    public Button(Rectanglef bounds, String text, IActionListener listener) {
        super(bounds);
        this.text = text;
        this.listener = listener;

        this.onGUIResized(Game.INSTANCE.getRender().getWidth(), Game.INSTANCE.getRender().getHeight());
    }

    @Override
    public void render(Render render) {
        super.render(render);
        render.draw(this.pressed ? this.texturePressed : this.hovered && !Util.isAndroid() ? this.textureHovered : this.textureNormal, this.bounds.getX(), this.bounds.getY());
        if(!Strings.isNullOrEmpty(this.text)) render.drawBigCenteredString(this.text, (int) (this.bounds.getX() + (this.bounds.getWidth() / 2)), (int) (this.bounds.getY() + (this.bounds.getHeight() / 2)));
    }

    @Override
    public boolean touchDown(Vector2i point, int pointer, int button) {
        if (this.bounds.contains(point)) {
            this.pressed = true;
            this.pressPointer = pointer;
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2i point, int pointer, int button) {
        if (this.bounds.contains(point)) {
            this.pressed = false;
            if (this.listener != null) listener.actionPerformed(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged(Vector2i point, int pointer) {
        if (pointer == this.pressPointer && !this.bounds.contains(point)) {
            this.hovered = false;
            this.pressed = false;
        } else if (this.bounds.contains(point)) {
            this.pressed = true;
            this.hovered = true;
            this.pressPointer = pointer;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(Vector2i point) {
        return this.hovered = this.bounds.contains(point);
    }

    @Override
    public void onGUIResized(int width, int height) {
        super.onGUIResized(width, height);

        if (this.textureNormal != null) this.textureNormal.dispose();
        if (this.textureHovered != null) this.textureHovered.dispose();
        if (this.texturePressed != null) this.texturePressed.dispose();

        this.textureNormal = this.getTexture(Color.LIGHT_GRAY, Color.BLACK);
        this.textureHovered = this.getTexture(Color.GRAY, Color.BLACK);
        this.texturePressed = this.getTexture(Color.DARK_GRAY, Color.BLACK);
    }

    public Texture getTexture(Color fill, Color border) {
        Pixmap pixmap = new Pixmap((int) this.getWidth(), (int) this.getHeight(), Pixmap.Format.RGBA8888);

        final int MARGIN = 2;

        pixmap.setColor(fill);
        pixmap.fillRectangle(MARGIN, MARGIN, (int) (getWidth() - MARGIN * 2), (int) (getHeight() - MARGIN * 2));


        pixmap.setColor(border);
        pixmap.fillRectangle(MARGIN, 0, (int) (getWidth() - MARGIN * 2), MARGIN); // Top
        pixmap.fillRectangle(0, MARGIN, MARGIN, (int) (getHeight() - MARGIN * 2)); // Left

        pixmap.fillRectangle(MARGIN, (int) (getHeight() - MARGIN), (int) (getWidth() - MARGIN * 2), MARGIN); // Bottom
        pixmap.fillRectangle((int) (getWidth() - MARGIN), MARGIN, MARGIN, (int) (getHeight() - MARGIN * 2)); // Right

        pixmap.drawPixel(1, 1);
        pixmap.drawPixel((int) (getWidth() - MARGIN), 1);
        pixmap.drawPixel(1, (int) (getHeight() - MARGIN));
        pixmap.drawPixel((int) (getWidth() - MARGIN), (int) (getHeight() - MARGIN));

        pixmap.drawPixel(MARGIN, MARGIN);
        pixmap.drawPixel((int) (getWidth() - 3), MARGIN);
        pixmap.drawPixel(MARGIN, (int) (getHeight() - 3));
        pixmap.drawPixel((int) (getWidth() - 3), (int) (getHeight() - 3));

        Texture ret = new Texture(pixmap);
        pixmap.dispose();
        return ret;
    }

    @Override
    public void dispose() {
        super.dispose();
        this.textureNormal.dispose();
        this.textureHovered.dispose();
        this.texturePressed.dispose();
    }
}
