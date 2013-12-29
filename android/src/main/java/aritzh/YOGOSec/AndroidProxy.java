package aritzh.YOGOSec;

import YOGOSec.core.Game;
import YOGOSec.core.Proxy;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AndroidProxy implements Proxy {
    private final Game game;

    public AndroidProxy(Game game) {this.game = game;}

    @Override
    public void setResizable(boolean resizable) {

    }
}
