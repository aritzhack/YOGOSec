package YOGOSec.java;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import YOGOSec.core.Game;

public class GameDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
        config.title = "YOGOSec";
        config.addIcon("assets/icon128.png", Files.FileType.Internal);
        config.addIcon("assets/icon32.png", Files.FileType.Internal);
        config.addIcon("assets/icon16.png", Files.FileType.Internal);
		new LwjglApplication(Game.INSTANCE, config);
	}
}
