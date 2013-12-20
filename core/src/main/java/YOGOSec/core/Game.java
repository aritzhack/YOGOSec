package YOGOSec.core;

import YOGOSec.core.render.Render;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Game implements ApplicationListener {
    Texture texture;
    TextureAtlas atlas;
    float elapsed;
    Sprite corner, vertical, horizontal, bg, progress;
    private Render render;

    @Override
    public void create() {
        this.render = new Render(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
        this.atlas = new TextureAtlas("sheet.txt");
        this.corner = atlas.createSprite("progressbar-corner");
        this.vertical = atlas.createSprite("progressbar-vertical");
        this.horizontal = atlas.createSprite("progressbar-horizontal");
        this.bg = atlas.createSprite("progressbar-bg");
        this.progress = atlas.createSprite("progressbar-progress");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        elapsed += Gdx.graphics.getDeltaTime();
        this.render.start();

        this.render.draw(texture, 100 + 100 * (float) Math.cos(elapsed), 100 + 100 * (float) Math.sin(elapsed));
        this.drawProgressBar(0, 0, 15, 15, 0);

        this.render.end();
    }

    public void drawProgressBar(int x, int y, int width, int height, float progress) {

        if (width < 10) width = 10;
        if (height < 10) height = 10;

        this.render.draw(this.corner, x, y);
        this.corner.flip(true, false);
        this.render.draw(this.corner, x, y + height - 5);
        this.corner.flip(true, true);
        this.render.draw(this.corner, x + width - 5, y);
        this.corner.flip(false, true);
        this.render.draw(this.corner, x + width - 5, y + height - 5);
        this.corner.flip(false, true);

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        atlas.dispose();
    }
}
