package YOGOSec.core.util;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Log {

    public static final String TAG = "YOGOSec";

    public static void log(String message) {
        Gdx.app.log(TAG, message);
    }

    public static void log(Object object) {
        Log.error(object.toString());
    }

    public static void log(String message, Throwable throwable) {
        Gdx.app.log(TAG, message, throwable);
    }

    public static void log(Object object, Throwable throwable) {
        Log.error(object.toString(), throwable);
    }

    public static void error(String error) {
        Gdx.app.error(TAG, error);
    }

    public static void error(Object object) {
        Log.error(object.toString());
    }

    public static void error(String message, Throwable throwable) {
        Gdx.app.error(TAG, message, throwable);
    }

    public static void error(Object object, Throwable throwable) {
        Log.error(object.toString(), throwable);
    }

    public static void debug(String message) {
        Gdx.app.debug(TAG, message);
    }

    public static void debug(Object object) {
        Log.debug(object.toString());
    }

    public static void debug(String message, Throwable throwable) {
        Gdx.app.debug(TAG, message, throwable);
    }

    public static void debug(Object object, Throwable throwable) {
        Log.debug(object.toString(), throwable);
    }

    public static void setLevel(Level level) {
        Gdx.app.setLogLevel(level.getValue());
    }

    public static Level getLevel() {
        for (Level level : Level.values()) {
            if (level.getValue() == Gdx.app.getLogLevel()) return level;
        }
        return null;
    }

    public static enum Level {
        DEBUG(Application.LOG_DEBUG), ERROR(Application.LOG_ERROR), INFO(Application.LOG_INFO), NONE(Application.LOG_NONE);
        private int value;

        Level(int value) {
            this.value = value;
        }

        private int getValue() {
            return value;
        }
    }
}
