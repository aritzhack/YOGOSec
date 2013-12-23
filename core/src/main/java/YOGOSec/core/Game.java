package YOGOSec.core;

import YOGOSec.core.input.Input;
import YOGOSec.core.render.ProgressBar;
import YOGOSec.core.render.Render;
import YOGOSec.core.screens.MainMenuScreen;
import YOGOSec.core.screens.MyScreen;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class Game implements ApplicationListener {
    public static final Game INSTANCE;

    static {
        INSTANCE = new Game();
    }

    // public TextureAtlas atlas; TODO Uncomment when sheet is used
    float elapsed;
    private Render render;
    private ProgressBar progressBar;
    private float progress = 0.0f;
    private MyScreen screen;
    private Input input;

    private Game() {

    }

    public Render getRender() {
        return render;
    }

    @Override
    public void create() {
        this.input = new Input(this);
        this.render = new Render(4);
        this.setScreen(new MainMenuScreen(this));
        // this.atlas = new TextureAtlas("sheet.txt"); TODO Uncomment when sheet is used
        this.progressBar = new ProgressBar(0, 0, this.render.getWidth(), 10, 1f);
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void resize(int width, int height) {
        this.render.resized(width, height);
        if (this.screen != null) this.screen.resize(width, height);
        Gdx.app.log("YOGOSec", "Camera size set to: " + width + "x" + height);
    }

    @Override
    public void render() {
        if (this.screen != null) this.screen.render(this.render);
        elapsed += Gdx.graphics.getDeltaTime();
        progress += 0.01;

        this.render.start();

        this.progressBar.setProgress((float) Math.abs(Math.sin(this.progress)));
        this.progressBar.draw(this.render);

        this.render.end();
    }


    public void setScreen(MyScreen screen) {
        this.screen = screen;
    }

    public MyScreen getScreen() {
        return screen;
    }

    @Override
    public void pause() {
        if (this.screen != null) this.screen.pause();
    }

    @Override
    public void resume() {
        if (this.screen != null) this.screen.resume();
    }

    @Override
    public void dispose() {
        if (this.screen != null) this.screen.dispose();
        // atlas.dispose(); TODO Uncomment when sheet is used
    }
}
