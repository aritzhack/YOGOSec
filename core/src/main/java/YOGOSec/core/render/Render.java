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
 * Utility class to make it simpler to render things into the screen through a {@link com.badlogic.gdx.graphics.g2d.SpriteBatch} and using a {@link com.badlogic.gdx.graphics.OrthographicCamera}.
 *
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

    /**
     * Creates a render with a default scale of one (therefore without scaling) and with the specified size.
     *
     * @param width  The width of the renderer.
     * @param height The height of the renderer.
     * @see YOGOSec.core.render.Render#Render(int, int, float) new Render(int, int, float)
     */
    public Render(int width, int height) {
        this(width, height, 1f);
    }

    /**
     * Creates a renderer with the specified size and scale. Everything drawn to the screen will be scaled by that factor (scale = 2 means everything will be shown twice as big).
     *
     * @param width  The width of the renderer.
     * @param height The height of the renderer.
     * @param scale  The scale of the renderer.
     */
    public Render(int width, int height, float scale) {
        this.scale = scale;
        this.batch = new SpriteBatch();
        this.width = width;
        this.height = height;
        this.camera = new OrthographicCamera(this.width / this.scale, this.height / this.scale);
        this.fontSmall = new BitmapFont();
        this.fontBig = new BitmapFont(Gdx.files.internal("arial32.fnt"));
    }

    /**
     * Creates a default renderer with a size filling the window, and a scale of one.
     *
     * @see YOGOSec.core.render.Render#Render(int, int, float) new Render(int, int, float)
     * @see com.badlogic.gdx.Graphics#getWidth() Gdx.graphics.getWidth()
     * @see com.badlogic.gdx.Graphics#getHeight()  Gdx.graphics.getHeight()
     */
    public Render() {
        this(1f);
    }

    /**
     * Creates a renderer with the specified scale and a size that fills the window.
     *
     * @param scale The The scale of the renderer.
     * @see YOGOSec.core.render.Render#Render(int, int, float) new Render(int, int, float)
     * @see com.badlogic.gdx.Graphics#getWidth() Gdx.graphics.getWidth()
     * @see com.badlogic.gdx.Graphics#getHeight()  Gdx.graphics.getHeight()
     */
    public Render(float scale) {
        this(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), scale);
    }

    /**
     * This should be called by the game each time the renderer should be resized (i.e. when the window is resized).
     *
     * @param width  The new width of the renderer.
     * @param height The new height of the renderer.
     */
    public void resized(int width, int height) {
        this.camera.setToOrtho(false, width / this.scale, height / this.scale);
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the camera used by this renderer. Useful to unproject coordinates from input coordinates to actual game coordinates.
     *
     * @return the camera used by this renderer.
     */
    public OrthographicCamera getCamera() {
        return camera;
    }

    /**
     * Starts the rendering cycle of the renderer. This must be called at the very beginning of each render cycle.
     *
     * @see YOGOSec.core.render.Render#end()
     */
    public void start() {
        Gdx.gl.glClearColor(0, 1, 1, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
    }

    /**
     * Ends the rendering cycle. This must be called at the very end of each render cycle.
     *
     * @throws java.lang.IllegalStateException If this has been called, but {@link YOGOSec.core.render.Render#start()} hadn't been called.
     */
    public void end() {
        this.batch.end();
    }

    /**
     * Draws a texture at the specified coordinates.
     *
     * @param texture The texture to draw.
     * @param x       The x position (positive x goes to the right).
     * @param y       The y position (positive y goes upwards).
     */
    public void draw(Texture texture, float x, float y) {
        this.batch.draw(texture, x, y);
    }

    /**
     * Draws a texture with the bottom-left corner at the specified coordinates.
     *
     * @param texture The texture to draw.
     * @param x       The x position of the bottom left corner of the texture (positive x goes to the right).
     * @param y       The y position of the bottom left corner of the texture (positive y goes upwards).
     */
    public void draw(TextureRegion texture, float x, float y) {
        this.batch.draw(texture, x, y);
    }

    /**
     * Draws a texture centered at the specified location and with the specified size.
     *
     * @param texture The The texture to draw.
     * @param x       The x position of the center of the texture (positive x goes to the right).
     * @param y       The y position of the center of the texture (positive y goes upwards).
     * @param width   The with with which the texture will be drawn.
     * @param height  The height with which the texture will be drawn.
     */
    public void drawCentered(Texture texture, float x, float y, float width, float height) {
        this.batch.draw(texture, (x - width / 2), (y - height / 2), width, height);
    }

    /**
     * Draws a texture centered at the specified location and with the specified size.
     *
     * @param texture The The texture to draw.
     * @param x       The x position of the center of the texture (positive x goes to the right).
     * @param y       The y position of the center of the texture (positive y goes upwards).
     * @param width   The with with which the texture will be drawn.
     * @param height  The height with which the texture will be drawn.
     */
    public void drawCentered(TextureRegion texture, float x, float y, float width, float height) {
        this.batch.draw(texture, (x - width / 2), (y - height / 2), width, height);
    }

    /**
     * Draws a texture centered at the specified location.
     *
     * @param texture The The texture to draw.
     * @param x       The x position of the center of the texture (positive x goes to the right).
     * @param y       The y position of the center of the texture (positive y goes upwards).
     */
    public void drawCentered(Texture texture, float x, float y) {
        this.batch.draw(texture, (x - texture.getWidth() / 2), (y - texture.getHeight() / 2));
    }

    /**
     * Draws a texture centered at the specified location.
     *
     * @param texture The The texture to draw.
     * @param x       The x position of the center of the texture (positive x goes to the right).
     * @param y       The y position of the center of the texture (positive y goes upwards).
     */
    public void drawCentered(TextureRegion texture, float x, float y) {
        this.batch.draw(texture, (x - texture.getRegionWidth() / 2), (y - texture.getRegionHeight() / 2));
    }

    /**
     * Draws a texture with the bottom-left corner the specified location scaled with the specified factors.
     *
     * @param texture The The texture to draw.
     * @param x       The x position of the bottom-left corner of the texture (positive x goes to the right).
     * @param y       The y position of the bottom-left corner of the texture (positive y goes upwards).
     * @param scaleX  The horizontal scale to apply to the texture.
     * @param scaleY  The vertical scale to appy to the texture.
     */
    public void drawScaled(Texture texture, float x, float y, float scaleX, float scaleY) {
        this.draw(texture, x, y, texture.getWidth() * scaleX, texture.getHeight() * scaleY);
    }

    /**
     * Draws a texture with the bottom-left corner at the specified location and with the specified size.
     *
     * @param texture The The texture to draw.
     * @param x       The x position of the bottom left corner of the texture (positive x goes to the right).
     * @param y       The y position of the bottom left corner of the texture (positive y goes upwards).
     * @param width   The with with which the texture will be drawn.
     * @param height  The height with which the texture will be drawn.
     */
    public void draw(Texture texture, float x, float y, float width, float height) {
        this.batch.draw(texture, x, y, width, height);
    }

    /**
     * Draws a texture centered at the specified location scaled with the specified factors.
     *
     * @param texture The The texture to draw.
     * @param x       The x position of the top left corner of the texture (positive x goes to the right).
     * @param y       The y position of the top left corner of the texture (positive y goes upwards).
     * @param scaleX  The horizontal scale to apply to the texture.
     * @param scaleY  The vertical scale to appy to the texture.
     */
    public void drawScaled(TextureRegion texture, float x, float y, float scaleX, float scaleY) {
        this.draw(texture, x, y, texture.getRegionWidth() * scaleX, texture.getRegionHeight() * scaleY);
    }

    /**
     * Draws a texture with the bottom-left corner at the specified location and with the specified size.
     *
     * @param texture The The texture to draw.
     * @param x       The x position of the bottom left corner of the texture (positive x goes to the right)
     * @param y       The y position of the bottom left corner of the texture (positive y goes upwards).
     * @param width   The with with which the texture will be drawn.
     * @param height  The height with which the texture will be drawn.
     */
    public void draw(TextureRegion texture, float x, float y, float width, float height) {
        this.batch.draw(texture, x, y, width, height);
    }

    /**
     * Sets the font color.
     *
     * @param color The color to set the font to.
     */
    public void setFontColor(Color color) {
        this.fontBig.setColor(color);
        this.fontSmall.setColor(color);
    }

    /**
     * Draws a string with the bottom-left corner at the specified location. Uses the default 15pt Arial font.
     *
     * @param text The string to draw.
     * @param x    The x position of the bottom-left corner of the string.
     * @param y    The y position of the bottom-left corner of the string.
     */
    public void drawString(String text, int x, int y) {
        this.drawString(this.fontSmall, text, x, y);
    }

    /**
     * Draws a string with the bottom-left corner at the specified location using the specified BitmapFont.
     *
     * @param font The font to draw the string with.
     * @param text The string to draw.
     * @param x    The x position of the bottom-left corner of the string.
     * @param y    The y position of the bottom-left corner of the string.
     */
    private void drawString(BitmapFont font, String text, int x, int y) {
        font.draw(this.batch, text, x, y);
    }

    /**
     * Draws a string with the bottom-left corner at the specified location. Uses a 32pt Arial font.
     *
     * @param text The string to draw.
     * @param x    The x position of the bottom-left corner of the string.
     * @param y    The y position of the bottom-left corner of the string.
     */
    public void drawBigString(String text, int x, int y) {
        this.drawString(this.fontBig, text, x, y);
    }

    /**
     * Draws a string with the center at the specified location. Uses the default 15pt Arial font.
     *
     * @param text The string to draw.
     * @param x    The x position of the center of the string.
     * @param y    The y position of the center of the string.
     */
    public void drawCenteredString(String text, int x, int y) {
        this.drawCenteredString(this.fontSmall, text, x, y);
    }

    /**
     * Draws a string with the center at the specified location, using the specified BitmapFont.
     *
     * @param text The string to draw.
     * @param x    The x position of the center of the string.
     * @param y    The y position of the center of the string.
     */
    private void drawCenteredString(BitmapFont font, String text, int x, int y) {
        BitmapFont.TextBounds bounds = font.getBounds(text);
        this.drawString(font, text, (int) (x - (bounds.width / 2)), (int) (y + (font.getLineHeight() / 2)));
    }

    /**
     * Draws a string with the center at the specified location. Uses a 32pt Arial font.
     *
     * @param text The string to draw.
     * @param x    The x position of the center of the string.
     * @param y    The y position of the center of the string.
     */
    public void drawBigCenteredString(String text, int x, int y) {
        this.drawCenteredString(this.fontBig, text, x, y);
    }

    /**
     * Returns the width of the renderer.
     *
     * @return the width of the renderer.
     */
    public int getWidth() {
        return (int) (width / scale);
    }

    /**
     * Returns the height of the renderer.
     *
     * @return the height of the renderer.
     */
    public int getHeight() {
        return (int) (height / scale);
    }

    /**
     * Returns the SpriteBatch used to render all the textures and text.
     *
     * @return the SpriteBatch used to render all the textures and text.
     */
    public SpriteBatch getBatch() {
        return batch;
    }
}
