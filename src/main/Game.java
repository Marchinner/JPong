package main;

import entities.Ball;
import entities.Enemy;
import entities.Player;
import inputs.KeyboardManager;
import utilz.Constants.PADDLE;
import utilz.Constants.BALL;
import utilz.Constants.GAME_WINDOW;

import java.awt.*;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Player player;
    private Enemy enemy;
    private Ball ball;
    private KeyboardManager keyboardManager = new KeyboardManager();

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
        player = new Player(
                PADDLE.X_SPAWN_POINT,
                PADDLE.Y_SPAWN_POINT,
                PADDLE.WIDTH,
                PADDLE.HEIGHT,
                PADDLE.COLOR,
                PADDLE.SPEED,
                keyboardManager);

        ball = new Ball(
                GAME_WINDOW.WIDTH / 2f,
                GAME_WINDOW.HEIGHT / 2f,
                BALL.WIDTH,
                BALL.HEIGHT,
                BALL.COLOR,
                BALL.SPEED,
                player,
                enemy
        );

        enemy = new Enemy(
                GAME_WINDOW.WIDTH - PADDLE.X_SPAWN_POINT,
                PADDLE.Y_SPAWN_POINT,
                PADDLE.WIDTH,
                PADDLE.HEIGHT,
                PADDLE.COLOR,
                PADDLE.SPEED,
                ball
        );
    }

    private void update() {
        player.update();
        enemy.update();
        ball.update();
    }

    public void render(Graphics graphics) {
        background(graphics);
        player.draw(graphics);
        enemy.draw(graphics);
        ball.draw(graphics);
    }

    private void background(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, GAME_WINDOW.WIDTH, GAME_WINDOW.HEIGHT);
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
