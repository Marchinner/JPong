package main;

import inputs.KeyboardManager;
import utilz.Constants.GAME_WINDOW;

import javax.swing.*;

public class GameWindow extends JFrame {

    private JFrame gameWindow;
    private ImageIcon windowIcon = null;

    public GameWindow(GamePanel gamePanel) {
        java.net.URL windowIconUrl = GameWindow.class.getResource("/icon.png");
        gameWindow = new JFrame();
        if (windowIconUrl != null) {
            windowIcon = new ImageIcon(windowIconUrl);
            gameWindow.setIconImage(windowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(this, "Icon image not found!");
        }
        gameWindow.setTitle(GAME_WINDOW.TITLE);
        gameWindow.setResizable(false);
        gameWindow.add(gamePanel);
        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }
}
