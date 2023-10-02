package gamestates;

import inputs.MouseManager;
import main.Game;
import ui.UI;
import static ui.Languages.*;
import static utilz.Constants.COLORS.DEFAULT_FOREGROUND_COLOR;

import utilz.Constants;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Paused {
    private Game game;
    private MouseManager mouseManager;
    private UI.Button resumeButton;
    private UI.Button restartButton;
    private UI.Button mainMenuButton;

    public Paused(Game game, MouseManager mouseManager) {
        this.game = game;
        this.mouseManager = mouseManager;
        resumeButton = new UI.Button(
                game,
                Constants.GAME_WINDOW.WIDTH / 2,
                250,
                RESUME_BUTTON_TEXT,
                Color.BLACK,
                DEFAULT_FOREGROUND_COLOR,
                32f);

        restartButton = new UI.Button(
                game,
                Constants.GAME_WINDOW.WIDTH / 2,
                450,
                RESTART_BUTTON_TEXT,
                Color.BLACK,
                DEFAULT_FOREGROUND_COLOR,
                32f
        );
        mainMenuButton = new UI.Button(
                game,
                Constants.GAME_WINDOW.WIDTH / 2,
                550,
                BACK_TO_MAIN_MENU_TEXT,
                Color.BLACK,
                DEFAULT_FOREGROUND_COLOR,
                32f
        );
    }

    public UI.Button getResumeButton() {
        return resumeButton;
    }

    public UI.Button getRestartButton() {
        return restartButton;
    }

    public UI.Button getMainMenuButton() {
        return mainMenuButton;
    }

    public void update() {

    }

    public void draw(Graphics graphics) {
        int fontWidth;
        int fontHeight;
        graphics.setColor(Constants.GAME_WINDOW.backgroundColor);
        graphics.fillRect(0, 0, Constants.GAME_WINDOW.WIDTH, Constants.GAME_WINDOW.HEIGHT);
        graphics.setColor(Color.RED);
        graphics.setFont(graphics.getFont().deriveFont(80f));
        fontWidth = graphics.getFontMetrics().stringWidth(GAME_PAUSED_TEXT);
        fontHeight = graphics.getFontMetrics().getMaxAscent() - graphics.getFontMetrics().getDescent();
        graphics.drawString(GAME_PAUSED_TEXT, Constants.GAME_WINDOW.WIDTH / 2 - (fontWidth / 2), 100);
        resumeButton.draw(graphics);
        restartButton.draw(graphics);
        mainMenuButton.draw(graphics);
    }
}
