package YOGOSec.core.util;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

/**
 * Miscellaneous utility class
 *
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Util {

    /**
     * Returns true if the current platform is Android. False otherwise
     * @return true if the current platform is Android. False otherwise
     */
    public static boolean isAndroid() {
        return Gdx.app.getType() == Application.ApplicationType.Android;
    }

    /**
     * Returns true if the current platform is the Desktop. False otherwise
     * @return true if the current platform is the Desktop. False otherwise
     */
    public static boolean isDesktop() {
        return Gdx.app.getType() == Application.ApplicationType.Desktop;
    }

    /**
     * Rounds a float value to the specified amount of decimal places
     * @param value The value to round
     * @param decimalPlaces The amount of decimal places
     * @return {@code value} rounded to {@code decimalPlaces} decimal places
     * @see Util#round(double, int) Util.round(double, int)
     */
    public static float round(float value, int decimalPlaces) {
        return (float) Util.round((double) value, decimalPlaces);
    }

    /**
     * Rounds a double value to the specified amount of decimal places
     * @param value The value to round
     * @param decimalPlaces The amount of decimal places
     * @return {@code value} rounded to {@code decimalPlaces} decimal places
     */
    public static double round(double value, int decimalPlaces) {
        double rounder = Math.pow(10, decimalPlaces);
        return Math.round(value*rounder) / rounder;
    }

    /**
     * Whether the app is running in debug mode or not
     */
    public static final boolean DEUBG = System.getProperty("debug") != null;
}
