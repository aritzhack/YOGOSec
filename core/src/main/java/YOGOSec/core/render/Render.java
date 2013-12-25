package YOGOSec.core.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Render {

    private final SpriteBatch batch;
    private final OrthographicCamera camera;
    private final BitmapFont fontSmall, fontBig;
    private int width;
    private int height;
    private float scale;

    public Render(int width, int height) {
        this(width, height, 1f);
    }

    public Render(int width, int height, float scale) {
        this.scale = scale;
        this.batch = new SpriteBatch();
        this.width = width;
        this.height = height;
        this.camera = new OrthographicCamera(this.width / this.scale, this.height / this.scale);
        this.fontSmall = new BitmapFont();
        this.fontBig = new BitmapFont(Gdx.files.internal("arial32.fnt"));
    }

    public Render() {
        this(1f);
    }

    public Render(float scale) {
        this(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), scale);
    }

    public void resized(int width, int height) {
        this.camera.setToOrtho(false, width / this.scale, height / this.scale);
        this.width = width;
        this.height = height;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void start() {
        Gdx.gl.glClearColor(0, 1, 1, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
    }

    public void end() {
        this.batch.end();
    }

    public void draw(Texture texture, float x, float y) {
        this.batch.draw(texture, x, y);
    }

    public void draw(TextureRegion texture, float x, float y) {
        this.batch.draw(texture, x, y);
    }

    public void drawCentered(Texture texture, float x, float y, float width, float height) {
        this.batch.draw(texture, (x - width / 2), (y - height / 2), width, height);
    }

    public void drawCentered(TextureRegion texture, float x, float y, float width, float height) {
        this.batch.draw(texture, (x - width / 2), (y - height / 2), width, height);
    }

    public void drawCentered(Texture texture, float x, float y) {
        this.batch.draw(texture, (x - texture.getWidth() / 2), (y - texture.getHeight() / 2));
    }

    public void drawCentered(TextureRegion texture, float x, float y) {
        this.batch.draw(texture, (x - texture.getRegionWidth() / 2), (y - texture.getRegionHeight() / 2));
    }

    public void drawScaled(Texture texture, float x, float y, float scaleX, float scaleY) {
        this.draw(texture, x, y, texture.getWidth() * scaleX, texture.getHeight() * scaleY);
    }

    public void draw(Texture texture, float x, float y, float width, float height) {
        this.batch.draw(texture, x, y, width, height);
    }

    public void drawScaled(TextureRegion texture, float x, float y, float scaleX, float scaleY) {
        this.draw(texture, x, y, texture.getRegionWidth() * scaleX, texture.getRegionHeight() * scaleY);
    }

    public void draw(TextureRegion texture, float x, float y, float width, float height) {
        this.batch.draw(texture, x, y, width, height);
    }

    public void setFontColor(Color color) {
        this.fontBig.setColor(color);
        this.fontSmall.setColor(color);
    }

    public void drawString(String text, int x, int y) {
        this.drawString(this.fontSmall, text, x, y);
    }

    private void drawString(BitmapFont font, String text, int x, int y) {
        font.draw(this.batch, text, x, y);
    }

    public void drawBigString(String text, int x, int y) {
        this.drawString(this.fontBig, text, x, y);
    }

    public void drawCenteredString(String text, int x, int y) {
        this.drawCenteredString(this.fontSmall, text, x, y);
    }

    private void drawCenteredString(BitmapFont font, String text, int x, int y) {
        BitmapFont.TextBounds bounds = font.getBounds(text);
        this.drawString(font, text, (int) (x - (bounds.width / 2)), (int) (y + (font.getLineHeight() / 2)));
    }

    public void drawBigCenteredString(String text, int x, int y) {
        this.drawCenteredString(this.fontBig, text, x, y);
    }

    public int getWidth() {
        return (int) (width / scale);
    }

    public int getHeight() {
        return (int) (height / scale);
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
