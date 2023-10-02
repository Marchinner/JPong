package gamestates;

import inputs.KeyboardManager;
import inputs.MouseManager;
import main.Game;
import ui.UI;
import static ui.Languages.*;
import static utilz.Constants.COLORS.DEFAULT_FOREGROUND_COLOR;

import utilz.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MainMenu {
    private UI.Button play;
    private UI.Button quit;
    private Game game;
    private BufferedImage gameLogo = null;
    private BufferedImage brazilFlag = null;
    private BufferedImage usaFlag = null;
    private UI.Button brazilButton;
    private UI.Button usaButton;

    public MainMenu(Game game, MouseManager mouseManager) {
        play = new UI.Button(
                game,
                Constants.GAME_WINDOW.WIDTH / 2,
                Constants.GAME_WINDOW.HEIGHT / 2,
                PLAY_BUTTON_TEXT,
                Color.BLACK,
                DEFAULT_FOREGROUND_COLOR,
                36f);

        quit = new UI.Button(
                game,
                Constants.GAME_WINDOW.WIDTH / 2,
                Constants.GAME_WINDOW.HEIGHT / 2 + 80,
                EXIT_BUTTON_TEXT,
                Color.BLACK,
                DEFAULT_FOREGROUND_COLOR,
                32f
        );

        brazilButton = new UI.Button(
                game,
                280,
                500,
                100,
                53
        );

        usaButton = new UI.Button(
                game,
                420,
                500,
                100,
                53
        );
    }

    public void update() {

    }

    public void draw(Graphics graphics) {
        graphics.setColor(Constants.GAME_WINDOW.backgroundColor);
        graphics.fillRect(0, 0, Constants.GAME_WINDOW.WIDTH, Constants.GAME_WINDOW.HEIGHT);
        drawLogo(graphics);
        play.draw(graphics);
        quit.draw(graphics);
        drawFlags(graphics);
    }

    private void drawLogo(Graphics graphics) {
        InputStream inputStream = Game.class.getResourceAsStream(Constants.MAIN_MENU.GAME_LOGO);
        try {
            gameLogo = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        graphics.drawImage(gameLogo, Constants.GAME_WINDOW.WIDTH / 2 - gameLogo.getWidth() / 2, 10, null);
    }

    private void drawFlags(Graphics graphics) {
        InputStream brazilFlagInputStream = Game.class.getResourceAsStream(Constants.MAIN_MENU.BRAZIL_FLAG);
        InputStream usaFlagInputStream = Game.class.getResourceAsStream(Constants.MAIN_MENU.USA_FLAG);

        try {
            brazilFlag = ImageIO.read(brazilFlagInputStream);
            usaFlag = ImageIO.read(usaFlagInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                brazilFlagInputStream.close();
                usaFlagInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        graphics.drawImage(brazilFlag, 280, 500, 100, 53, null);
        graphics.drawImage(usaFlag, 420, 500, 100, 53, null);
        graphics.drawRect(brazilButton.getButtonBox().x, brazilButton.getButtonBox().y,
                brazilButton.getButtonBox().width, brazilButton.getButtonBox().height);
        graphics.drawRect(usaButton.getButtonBox().x, usaButton.getButtonBox().y,
                usaButton.getButtonBox().width, usaButton.getButtonBox().height);
    }

    public UI.Button getBrazilButton() {
        return brazilButton;
    }

    public UI.Button getUsaButton() {
        return usaButton;
    }

    public UI.Button getPlay() {
        return play;
    }

    public UI.Button getQuit() {
        return quit;
    }
}
