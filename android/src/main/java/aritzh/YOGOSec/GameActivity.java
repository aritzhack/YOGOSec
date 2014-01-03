package aritzh.YOGOSec;

import YOGOSec.core.Game;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class GameActivity extends AndroidApplication {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useGL20 = true;
        Game.INSTANCE.setProxy(new AndroidProxy(Game.INSTANCE));
        initialize(Game.INSTANCE, config);
    }
}
