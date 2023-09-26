package main;

import entities.Ball;
import entities.Enemy;
import entities.Player;
import gamestates.*;
import inputs.KeyboardManager;
import inputs.MouseManager;
import ui.Language;
import ui.Languages;
import utilz.Constants.PADDLE;
import utilz.Constants.BALL;
import utilz.Constants.GAME_WINDOW;

import java.awt.*;

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
    private Paused paused;
    private Language language = Language.enUS;
    private Languages gameLanguage;

    public Game() {
        loadLanguage();
        initializeClasses();
        createGameWindow();
        startGameThread();
    }

    private void loadLanguage() {
        gameLanguage = new Languages(language);
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
        playing = new Playing(this, keyboardManager, player, enemy, ball, gameScore);
        gameOver = new GameOver();
        paused = new Paused(this, mouseManager);
    }

    private void update() {
        switch (gamestate) {
            case MAIN_MENU -> mainMenu.update();
            case PLAYING -> playing.update();
            case PAUSED -> paused.update();
        }
    }

    public void render(Graphics graphics) {
        switch (gamestate) {
            case MAIN_MENU -> mainMenu.draw(graphics);
            case PLAYING -> playing.draw(graphics);
            case GAME_OVER -> gameOver.draw(graphics);
            case PAUSED -> paused.draw(graphics);
        }
    }

    public Languages getGameLanguage() {
        return gameLanguage;
    }

    public void setGameLanguage(Languages gameLanguage) {
        this.gameLanguage = gameLanguage;
        initializeClasses();
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public Gamestate getGamestate() {
        return gamestate;
    }

    public Paused getPaused() {
        return paused;
    }

    public void setGamestate(Gamestate gamestate) {
        this.gamestate = gamestate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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

    public void restartGame() {
        gamestate = Gamestate.PLAYING;
        initializeClasses();
    }
}
