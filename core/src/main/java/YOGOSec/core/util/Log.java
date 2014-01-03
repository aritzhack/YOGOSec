package YOGOSec.core.util;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

/**
 * Utility class to make it easier to use LibGdx's logging system
 *
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Log {

    /**
     * Tag used when logging. It will be prepended in the console, and will be the tag used in logcat
     */
    public static final String TAG = "YOGOSec";

    /**
     * Logs a message to the standard output
     *
     * @param message The message to log
     */
    public static void log(String message) {
        Gdx.app.log(TAG, message);
    }

    /**
     * Logs an object to the standard output. Same as {@code Log.log(object.toString())}
     *
     * @param object The object to log
     */
    public static void log(Object object) {
        Log.error(object.toString());
    }

    /**
     * Logs a message to the error output
     *
     * @param message The message to log
     */
    public static void error(String message) {
        Gdx.app.error(TAG, message);
    }

    /**
     * Logs a message and prints the stack trace to the standard output
     *
     * @param message   The message to log
     * @param throwable The throwable of which stack trace to print
     */
    public static void log(String message, Throwable throwable) {
        Gdx.app.log(TAG, message, throwable);
    }

    /**
     * Logs an object and prints the stack trace of the {@link java.lang.Throwable} to standard output
     *
     * @param object    The object to log
     * @param throwable The throwable of which stack trace to print
     * @see Log#log(String, Throwable)
     */
    public static void log(Object object, Throwable throwable) {
        Log.error(object.toString(), throwable);
    }

    /**
     * Logs a message and prints the stack trace of the {@link java.lang.Throwable} to the error output
     *
     * @param message   The message to log
     * @param throwable The throwable of which stack trace to print
     */
    public static void error(String message, Throwable throwable) {
        Gdx.app.error(TAG, message, throwable);
    }

    /**
     * Logs an object to the error output
     *
     * @param object The object to log
     */
    public static void error(Object object) {
        Log.error(object.toString());
    }

    /**
     * Logs an object and prints the stack trace of the {@link java.lang.Throwable} to the error output
     *
     * @param object    The object to log
     * @param throwable The throwable of which stack trace to print
     */
    public static void error(Object object, Throwable throwable) {
        Log.error(object.toString(), throwable);
    }

    /**
     * Logs and object to the standard output if the {@link YOGOSec.core.util.Log.Level#DEBUG} log level is set
     *
     * @param object The object to log
     */
    public static void debug(Object object) {
        Log.debug(object.toString());
    }

    /**
     * Logs a message to the standard output if the {@link YOGOSec.core.util.Log.Level#DEBUG} log level is set
     *
     * @param message The message to log
     */
    public static void debug(String message) {
        Gdx.app.debug(TAG, message);
    }

    public static void debug(Object object, Throwable throwable) {
        Log.debug(object.toString(), throwable);
    }

    /**
     * Logs and object and the stack trace of the {@link java.lang.Throwable} to the standard output if the {@link YOGOSec.core.util.Log.Level#DEBUG} log level is set
     *
     * @param message   The The message to log
     * @param throwable The throwable of which stack trace to print
     */
    public static void debug(String message, Throwable throwable) {
        Gdx.app.debug(TAG, message, throwable);
    }

    /**
     * Returns the logging level currently set. If it is not equal to one of the defaults (those in {@link com.badlogic.gdx.Application}), {@code null} will be returned
     *
     * @return the logging level currently set
     */
    public static Level getLevel() {
        for (Level level : Level.values()) {
            if (level.getValue() == Gdx.app.getLogLevel()) return level;
        }
        return null;
    }

    /**
     * Sets the logging level
     *
     * @param level The logging level to be set
     */
    public static void setLevel(Level level) {
        Gdx.app.setLogLevel(level.getValue());
    }

    /**
     * Utility enum to make it easier to set logging levels
     */
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
