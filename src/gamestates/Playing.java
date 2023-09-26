package gamestates;

import entities.Ball;
import entities.Enemy;
import entities.Player;
import inputs.KeyboardManager;
import main.Game;
import main.Score;
import utilz.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;

public class Playing {

    private BufferedImage gameBoard = null;
    private Player player;
    private Enemy enemy;
    private Ball ball;
    private Score score;
    private Game game;
    private KeyboardManager keyboardManager;

    public Playing(Game game, KeyboardManager keyboardManager, Player player, Enemy enemy, Ball ball, Score score) {
        this.game = game;
        this.keyboardManager = keyboardManager;
        this.player = player;
        this.enemy = enemy;
        this.ball = ball;
        this.score = score;
    }

    public void update() {
        player.update();
        ball.update();
        enemy.update(ball);
        if (score.getEnemyScore() >= 5) {
            game.setGamestate(Gamestate.GAME_OVER);
        }
        if (keyboardManager.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            game.setGamestate(Gamestate.PAUSED);
        }
    }

    public void draw(Graphics graphics) {
        background(graphics);
        player.draw(graphics);
        enemy.draw(graphics);
        ball.draw(graphics);
        score.draw(graphics);
    }

    private void background(Graphics graphics) {
        InputStream inputStream = Game.class.getResourceAsStream(Constants.BOARD.BOARD_SPRITE);
        try {
            gameBoard = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        graphics.setColor(Constants.GAME_WINDOW.backgroundColor);
        graphics.fillRect(0, 0, Constants.GAME_WINDOW.WIDTH, Constants.GAME_WINDOW.HEIGHT);

        graphics.drawImage(gameBoard, Constants.GAME_WINDOW.X_OFFSET, Constants.GAME_WINDOW.Y_OFFSET, Constants.GAME_WINDOW.WIDTH - Constants.GAME_WINDOW.X_OFFSET * 2,
                Constants.GAME_WINDOW.HEIGHT, null);
    }
}
