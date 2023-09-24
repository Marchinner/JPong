package main;

import entities.Ball;
import entities.Enemy;
import entities.Player;
import inputs.KeyboardManager;
import utilz.Constants;
import utilz.Constants.PADDLE;
import utilz.Constants.BALL;
import utilz.Constants.GAME_WINDOW;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Player player;
    private Enemy enemy;
    private Ball ball;
    private Score gameScore;
    private KeyboardManager keyboardManager = new KeyboardManager();
    private BufferedImage gameBoard = null;

    public Game() {
        initializeClasses();
        createGameWindow();
        startGameThread();
    }

    private void startGameThread() {
        System.out.println("Starting Game Thread");
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    private void createGameWindow() {
        System.out.println("Creating Game Window");
        gamePanel = new GamePanel(this);
        gamePanel.addKeyListener(keyboardManager);
        gameWindow = new GameWindow(gamePanel);
    }

    private void initializeClasses() {
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

        player = new Player(
                PADDLE.X_SPAWN_POINT,
                PADDLE.Y_SPAWN_POINT,
                PADDLE.WIDTH,
                PADDLE.HEIGHT,
                PADDLE.COLOR,
                PADDLE.SPEED,
                keyboardManager,
                "player");

        enemy = new Enemy(
                GAME_WINDOW.WIDTH - PADDLE.X_SPAWN_POINT,
                PADDLE.Y_SPAWN_POINT,
                PADDLE.WIDTH,
                PADDLE.HEIGHT,
                PADDLE.COLOR,
                PADDLE.SPEED,
                null,
                "enemy"
        );

        gameScore = new Score();

        ball = new Ball(
                GAME_WINDOW.WIDTH / 2f,
                GAME_WINDOW.HEIGHT / 2f,
                BALL.WIDTH,
                BALL.HEIGHT,
                BALL.COLOR,
                BALL.SPEED,
                null,
                player,
                enemy,
                "ball",
                gameScore
        );

    }

    private void update() {
        player.update();
        ball.update();
        enemy.update(ball);
    }

    public void render(Graphics graphics) {
        background(graphics);
        player.draw(graphics);
        enemy.draw(graphics);
        ball.draw(graphics);
        gameScore.draw(graphics);
    }

    private void background(Graphics graphics) {
//        graphics.setColor(Color.BLACK);
//        graphics.fillRect(0, 0, GAME_WINDOW.WIDTH, GAME_WINDOW.HEIGHT);

        graphics.drawImage(gameBoard, 0, 0, 800, 600, null);
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / GAME_WINDOW.FPS_LIMIT;
		double timePerUpdate = 1000000000.0 / GAME_WINDOW.UPS_LIMIT;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
//				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
    }
}
