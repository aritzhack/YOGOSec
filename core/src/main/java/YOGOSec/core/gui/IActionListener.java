package YOGOSec.core.gui;

/**
 * Simple interface that represent something that is called when an action happened in a GUIComponent.
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface IActionListener {

    /**
     * Called when an action was performed on {@code sender}.
     * @param sender The GUIComponent from which the action comes.
     */
    public void actionPerformed(GUIComponent sender);
}
