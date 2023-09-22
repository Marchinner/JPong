package entities;

import inputs.KeyboardManager;
import utilz.Constants;
import utilz.Constants.PADDLE;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    public Player(float xPosition, float yPosition, float width, float height, Color color, float speed,
                  KeyboardManager keyboardManager, String name) {
        super(xPosition, yPosition, width, height, color, speed, keyboardManager, name);
    }

    public void update() {
        if (getKeyboardManager().isKeyPressed(KeyEvent.VK_UP)) {
            moveUp();
        } else if (getKeyboardManager().isKeyPressed(KeyEvent.VK_DOWN)) {
            moveDown();
        }
    }

}
