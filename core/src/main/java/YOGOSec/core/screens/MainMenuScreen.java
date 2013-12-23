package YOGOSec.core.screens;

import YOGOSec.core.Game;
import YOGOSec.core.gui.GUIComponent;
import YOGOSec.core.render.Render;
import com.badlogic.gdx.graphics.OrthographicCamera;

import java.util.List;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MainMenuScreen extends MyScreen {
    public MainMenuScreen(Game game) {
        super(game, new OrthographicCamera());
    }

    @Override
    public List<GUIComponent> getComponents() {
        return null;
    }

    @Override
    public void render(Render render) {

    }
}
