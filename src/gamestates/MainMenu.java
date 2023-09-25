package gamestates;

import inputs.KeyboardManager;
import inputs.MouseManager;
import main.Game;
import ui.UI;
import utilz.Constants;

import java.awt.*;

public class MainMenu {
    private UI.Button play;
    private UI.Button quit;
    private Game game;

    public MainMenu(Game game, MouseManager mouseManager) {
        play = new UI.Button(
                Constants.GAME_WINDOW.WIDTH / 2,
                Constants.GAME_WINDOW.HEIGHT / 2,
                96,
                44,
                "PLAY",
                Color.RED,
                36f);

        quit = new UI.Button(
                Constants.GAME_WINDOW.WIDTH / 2,
                Constants.GAME_WINDOW.HEIGHT / 2 + 80,
                175,
                44,
                "EXIT GAME",
                Color.RED,
                32f
        );
    }

    public void update() {
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, Constants.GAME_WINDOW.WIDTH, Constants.GAME_WINDOW.HEIGHT);
        play.draw(graphics);
        quit.draw(graphics);
    }

    public UI.Button getPlay() {
        return play;
    }

    public UI.Button getQuit() {
        return quit;
    }
}
