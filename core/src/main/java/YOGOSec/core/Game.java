package YOGOSec.core;

import YOGOSec.core.gui.ProgressBar;
import YOGOSec.core.input.Input;
import YOGOSec.core.render.Render;
import YOGOSec.core.screens.MainMenuScreen;
import YOGOSec.core.screens.MyScreen;
import YOGOSec.core.util.Log;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.google.common.base.Preconditions;

public class Game implements ApplicationListener {
    public static final Game INSTANCE;
    public Proxy proxy;

    static {
        INSTANCE = new Game();
    }

    // public TextureAtlas atlas; TODO Uncomment when sheet is used
    private MyScreen screen;
    private Render render;
    private ProgressBar progressBar;

    private Game() {

    }

    public Render getRender() {
        return render;
    }

    @Override
    public void create() {
        if(this.getProxy().isDebug()) Log.setLevel(Log.Level.DEBUG);
        this.render = new Render();
        this.setScreen(new MainMenuScreen(this));

        // this.atlas = new TextureAtlas("sheet.txt"); TODO Uncomment when sheet is used

        Gdx.input.setInputProcessor(new Input(this));
    }

    @Override
    public void resize(int width, int height) {
        this.render.resized(width, height);
        if (this.screen != null) this.screen.resize(width, height);
        Log.log("Window size set to: " + width + "x" + height);
    }

    @Override
    public void render() {
        this.render.start();

        if (this.screen != null) this.screen.render(this.render);

        this.render.end();
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

    public MyScreen getScreen() {
        return screen;
    }

    public void setScreen(MyScreen screen) {
        Preconditions.checkArgument(screen != null, "Cannot switch to a null screen!");
        if(this.screen != null) this.screen.onClosing(screen);
        MyScreen temp = this.screen;
        this.screen = screen;
        this.screen.onOpening(temp);
        if(temp != null) temp.dispose();
    }

    public int getWidth() {
        return this.render.getWidth();
    }

    public int getHeight() {
        return this.render.getHeight();
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }
}
