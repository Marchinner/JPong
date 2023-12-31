package utilz;

import java.awt.*;

public class Constants {

    public static final class COLORS {
        public static final Color DEFAULT_FOREGROUND_COLOR = new Color(0, 174, 231);
    }

    public static final class GAME_WINDOW {
        public static final int FPS_LIMIT = 60;
        public static final int UPS_LIMIT = 120;
        public static final int X_OFFSET = 50;
        public static final int Y_OFFSET = 0;
        public static final String TITLE = "JPong";
        public static final int WIDTH = 800;
        public static final int HEIGHT = 600;
        public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
        public static final Color backgroundColor = new Color(150, 209, 243);
    }

    public static final class PADDLE {
        public static final String PLAYER_SPRITE = "/player.png";
        public static final String ENEMY_SPRITE = "/enemy.png";
        public static final float WIDTH = 10;
        public static final float HEIGHT = 100;
        public static final Color COLOR = Color.WHITE;
        public static final float X_SPAWN_POINT = 30;
        public static final float Y_SPAWN_POINT = (float ) (GAME_WINDOW.HEIGHT / 2) - HEIGHT / 2;
        public static final float SPEED = 2;
    }

    public static final class BALL {
        public static final float WIDTH = 10f;
        public static final float HEIGHT = 10f;
        public static final Color COLOR = Color.WHITE;
        public static final float SPEED = 2f;
        public static final double HIT_BONUS_SPEED = 1.2;
        public static final double MAX_VELOCITY = 10;
    }

    public static final class BOARD {
        public static final String BOARD_SPRITE = "/gameBoard.png";
    }

    public static final class SCORE {
        public static final int MAX_SCORE = 5;  // default score
//        public static final int MAX_SCORE = 1;  // debug score
    }

    public static final class MAIN_MENU {
        public static final String GAME_LOGO = "/icon.png";
        public static final String BRAZIL_FLAG = "/brazilFlag.png";
        public static final String USA_FLAG = "/usaFlag.png";
    }

}
