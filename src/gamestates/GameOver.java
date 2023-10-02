package gamestates;

import inputs.KeyboardManager;
import inputs.MouseManager;
import main.Game;
import ui.Languages;
import ui.UI;
import utilz.Constants;

import java.awt.*;

import static utilz.Constants.COLORS.DEFAULT_FOREGROUND_COLOR;

public class GameOver {

    private Game game;
    private UI.Button mainMenu;
    private MouseManager mouseManager;

    public GameOver(Game game, MouseManager mouseManager) {
        this.game = game;
        this.mouseManager = mouseManager;
        mainMenu = new UI.Button(
                game,
                Constants.GAME_WINDOW.WIDTH / 2,
                Constants.GAME_WINDOW.HEIGHT / 2 + 250,
                Languages.BACK_TO_MAIN_MENU_TEXT,
                Color.BLACK,
                DEFAULT_FOREGROUND_COLOR,
                32f
        );
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, Constants.GAME_WINDOW.WIDTH, Constants.GAME_WINDOW.HEIGHT);
        graphics.setFont(graphics.getFont().deriveFont(100f));
        graphics.setColor(Color.RED);
        graphics.drawString("GAME OVER", Constants.GAME_WINDOW.WIDTH / 2 - 300, Constants.GAME_WINDOW.HEIGHT / 2);
        mainMenu.draw(graphics);
    }

    public UI.Button getMainMenu() {
        return mainMenu;
    }
}
