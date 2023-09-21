package entities;

import inputs.KeyboardManager;
import utilz.Constants;
import utilz.Constants.PADDLE;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private KeyboardManager keyboardManager;

    public Player(float xPosition, float yPosition, float width, float height, Color color, float speed,
                  KeyboardManager keyboardManager) {
        super(xPosition, yPosition, width, height, color, speed);
        this.keyboardManager = keyboardManager;
    }

    public void update() {
        if (keyboardManager.isKeyPressed(KeyEvent.VK_UP)) {
            moveUp();
        } else if (keyboardManager.isKeyPressed(KeyEvent.VK_DOWN)) {
            moveDown();
        }
    }
}
