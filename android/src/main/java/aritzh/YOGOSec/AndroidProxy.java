package aritzh.YOGOSec;

import YOGOSec.core.Game;
import YOGOSec.core.Proxy;
import android.app.Activity;
import android.content.pm.ApplicationInfo;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AndroidProxy implements Proxy {
    private final Game game;
    private Activity activity;

    public AndroidProxy(Game game, Activity activity) {
        this.game = game;
        this.activity = activity;
    }

    @Override
    public void setResizable(boolean resizable) {

    }

    @Override
    public boolean isDebug() {
        return (activity.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }


}
