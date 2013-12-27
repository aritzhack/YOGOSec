package YOGOSec.core.util;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Util {

    public static boolean isAndroid(){
        return Gdx.app.getType() == Application.ApplicationType.Android;
    }

    public static boolean isDesktop(){
        return Gdx.app.getType() == Application.ApplicationType.Desktop;
    }
}
