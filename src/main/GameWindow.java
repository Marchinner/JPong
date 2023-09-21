package main;

import inputs.KeyboardManager;
import utilz.Constants.GAME_WINDOW;

import javax.swing.*;

public class GameWindow extends JFrame {

    private JFrame gameWindow;

    public GameWindow(GamePanel gamePanel) {
        gameWindow = new JFrame();
        gameWindow.setTitle(GAME_WINDOW.TITLE);
        gameWindow.setResizable(false);
        gameWindow.add(gamePanel);
        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }
}
