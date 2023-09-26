package gamestates;

import inputs.MouseManager;
import main.Game;
import ui.UI;
import utilz.Constants;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Paused {
    private Game game;
    private MouseManager mouseManager;
    private UI.Button resumeButton;
    private UI.Button restartButton;

    public Paused(Game game, MouseManager mouseManager) {
        this.game = game;
        this.mouseManager = mouseManager;
        resumeButton = new UI.Button(
                Constants.GAME_WINDOW.WIDTH / 2,
                250,
                124,
                44,
                "Resume",
                Color.RED,
                32f);

        restartButton = new UI.Button(
                Constants.GAME_WINDOW.WIDTH / 2,
                450,
                112,
                44,
                "Restart",
                Color.RED,
                32f
        );
    }

    public UI.Button getResumeButton() {
        return resumeButton;
    }

    public UI.Button getRestartButton() {
        return restartButton;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, Constants.GAME_WINDOW.WIDTH, Constants.GAME_WINDOW.HEIGHT);
        graphics.setColor(Color.RED);
        graphics.setFont(graphics.getFont().deriveFont(100f));
        graphics.drawString("GAME PAUSED!", Constants.GAME_WINDOW.HEIGHT / 2 - 280, 100);
        resumeButton.draw(graphics);
        restartButton.draw(graphics);
    }
}
