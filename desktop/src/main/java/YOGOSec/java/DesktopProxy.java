package YOGOSec.java;

import YOGOSec.core.Game;
import YOGOSec.core.Proxy;
import org.lwjgl.opengl.Display;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class DesktopProxy implements Proxy {

    private final Game game;

    public DesktopProxy(Game game) {
        this.game = game;
    }

    @Override
    public void setResizable(boolean resizable) {
        Display.setResizable(resizable);
    }
}
