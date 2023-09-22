package entities;

import inputs.KeyboardManager;

import java.awt.*;

public class Enemy extends Entity {

    public Enemy(float xPosition, float yPosition, float width, float height, Color color, float speed,
                 KeyboardManager keyboardManager, String name) {
        super(xPosition, yPosition, width, height, color, speed, keyboardManager, name);
    }

    public void update(Ball ball) {
        if (ball.getYPosition() > getYPosition() + getHeight() / 2) {
            moveDown();
        } else if (ball.getYPosition() < getYPosition() + getHeight() / 2) {
            moveUp();
        }
    }
}
