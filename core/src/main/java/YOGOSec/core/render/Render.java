package YOGOSec.core.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Render {

    private final SpriteBatch batch;
    private final int width, height;

    public Render(int width, int height){
        this.batch = new SpriteBatch();
        this.width = width;
        this.height = height;
    }

    public void start(){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        this.batch.begin();
    }

    public void end(){
        this.batch.end();
    }

    public void draw(Texture texture, float x, float y, float width, float height){
        this.batch.draw(texture, x, y, width, height);
    }

    public void draw(TextureRegion texture, float x, float y, float width, float height){
        this.batch.draw(texture, x, y, width, height);
    }

    public void draw(Texture texture, float x, float y){
        this.batch.draw(texture, x, y);
    }

    public void draw(TextureRegion texture, float x, float y){
        this.batch.draw(texture, x, y);
    }

}
