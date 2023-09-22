package utilz;

import java.awt.*;

public class Constants {
    public static final class GAME_WINDOW {
        public static final int FPS_LIMIT = 60;
        public static final int UPS_LIMIT = 120;
        public static final String TITLE = "JPong";
        public static final int WIDTH = 800;
        public static final int HEIGHT = 600;
        public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
    }

    public static final class PADDLE {
        public static final float WIDTH = 10;
        public static final float HEIGHT = 100;
        public static final Color COLOR = Color.WHITE;
        public static final float X_SPAWN_POINT = 30;
        public static final float Y_SPAWN_POINT = 30;
        public static final float SPEED = 2;
    }

    public static final class BALL {
        public static final float WIDTH = 10f;
        public static final float HEIGHT = 10f;
        public static final Color COLOR = Color.RED;
        public static final float SPEED = 2f;
        public static final float HIT_BONUS_SPEED = 1.2f;
    }


}
