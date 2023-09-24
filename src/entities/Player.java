package entities;

import inputs.KeyboardManager;
import utilz.Constants;
import utilz.Constants.PADDLE;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Player extends Entity {

    private BufferedImage playerSprite = null;

    public Player(float xPosition, float yPosition, float width, float height, Color color, float speed,
                  KeyboardManager keyboardManager, String name) {
        super(xPosition, yPosition, width, height, color, speed, keyboardManager, name);

        InputStream inputStream = Player.class.getResourceAsStream(PADDLE.PLAYER_SPRITE);
        try {
            playerSprite = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(playerSprite, (int) getXPosition() - 30, (int) getYPosition(), (int) getWidth() + 60,
                (int) getHeight(), null);
    }

    public void update() {
        if (getKeyboardManager().isKeyPressed(KeyEvent.VK_UP)) {
            moveUp();
        } else if (getKeyboardManager().isKeyPressed(KeyEvent.VK_DOWN)) {
            moveDown();
        }
    }

}
