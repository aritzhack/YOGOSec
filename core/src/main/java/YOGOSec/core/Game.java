package YOGOSec.core;

import YOGOSec.core.render.ProgressBar;
import YOGOSec.core.render.Render;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Game implements ApplicationListener {
    public static final Game INSTANCE;

    static {
        INSTANCE = new Game();
    }

    public TextureAtlas atlas;
    float elapsed;
    private Render render;
    private ProgressBar progressBar;
    private float progress = 0.0f;

    private Game() {

    }

    public Render getRender() {
        return render;
    }

    @Override
    public void create() {
        this.render = new Render(4);
        this.atlas = new TextureAtlas("sheet.txt");
        this.progressBar = new ProgressBar(0, 0, this.render.getWidth(), 10, 1f);
    }

    @Override
    public void resize(int width, int height) {
        this.render.resized(width, height);
        Gdx.app.log("YOGOSec", "Camera size set to: " + width + "x" + height);
    }

    @Override
    public void render() {
        elapsed += Gdx.graphics.getDeltaTime();
        progress+=0.01;

        this.render.start();

        this.progressBar.setProgress((float) Math.abs(Math.sin(this.progress)));
        this.progressBar.draw(this.render);

        this.render.end();
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
