package gamestates;

import utilz.Constants;

import java.awt.*;

public class GameOver {

    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, Constants.GAME_WINDOW.WIDTH, Constants.GAME_WINDOW.HEIGHT);
        graphics.setFont(graphics.getFont().deriveFont(100f));
        graphics.setColor(Color.RED);
        graphics.drawString("GAME OVER", Constants.GAME_WINDOW.WIDTH / 2 - 300, Constants.GAME_WINDOW.HEIGHT / 2);
    }
}
