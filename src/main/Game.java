package main;

import entities.Ball;
import entities.Enemy;
import entities.Player;
import gamestates.*;
import inputs.KeyboardManager;
import inputs.MouseManager;
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
    private Gamestate gamestate = Gamestate.MAIN_MENU;
    private Player player;
    private Enemy enemy;
    private Ball ball;
    private Score gameScore;
    private KeyboardManager keyboardManager = new KeyboardManager();
    private MouseManager mouseManager;
    private Playing playing;
    private MainMenu mainMenu;
    private GameOver gameOver;

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
        mouseManager = new MouseManager(gamePanel);
        gamePanel.addMouseListener(mouseManager);
        gamePanel.addMouseMotionListener(mouseManager);
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

        mainMenu = new MainMenu(this, mouseManager);
        playing = new Playing(this, player, enemy, ball, gameScore);
        gameOver = new GameOver();
    }

    private void update() {
        switch (gamestate) {
            case MAIN_MENU -> mainMenu.update();
            case PLAYING -> playing.update();
        }
    }

    public void render(Graphics graphics) {
        switch (gamestate) {
            case MAIN_MENU -> mainMenu.draw(graphics);
            case PLAYING -> playing.draw(graphics);
            case GAME_OVER -> gameOver.draw(graphics);
        }
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public Gamestate getGamestate() {
        return gamestate;
    }

    public void setGamestate(Gamestate gamestate) {
        this.gamestate = gamestate;
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
