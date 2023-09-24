package entities;

import inputs.KeyboardManager;
import utilz.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Enemy extends Entity {

    BufferedImage enemySprite = null;

    public Enemy(float xPosition, float yPosition, float width, float height, Color color, float speed,
                 KeyboardManager keyboardManager, String name) {
        super(xPosition, yPosition, width, height, color, speed, keyboardManager, name);

        InputStream inputStream = Player.class.getResourceAsStream(Constants.PADDLE.ENEMY_SPRITE);
        try {
            enemySprite = ImageIO.read(inputStream);
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

    public void update(Ball ball) {
        if (ball.getYPosition() > getYPosition() + getHeight() / 2) {
            moveDown();
        } else if (ball.getYPosition() < getYPosition() + getHeight() / 2) {
            moveUp();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(enemySprite, (int) getXPosition() - 50, (int) getYPosition(), (int) getWidth() + 60,
                (int) getHeight(), null);
    }
}
