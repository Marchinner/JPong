package entities;

import inputs.KeyboardManager;
import utilz.Constants.PADDLE;
import utilz.Constants.GAME_WINDOW;

import java.awt.*;

public class Entity {

    private float xPosition;
    private float yPosition;
    private float width;
    private float height;
    private Color color;
    private float speed;
    private KeyboardManager keyboardManager;

    public String name;

    public Entity(float xPosition, float yPosition, float width, float height, Color color, float speed,
                  KeyboardManager keyboardManager, String name) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.color = color;
        this.speed = speed;
        this.keyboardManager = keyboardManager;
        this.name = name;
    }

    protected boolean canMoveUp() {
        return yPosition - speed > 0;
    }

    protected void moveUp() {
        if (canMoveUp())
            setYPosition(getYPosition() - getSpeed());
    }

    protected boolean canMoveRight() {
        return xPosition + speed < GAME_WINDOW.WIDTH;
    }

    protected void moveRight() {
        if (canMoveRight()) {
            setXPosition(getXPosition() + getSpeed());
        }
    }

    protected boolean canMoveDown() {
        return yPosition + height + speed < GAME_WINDOW.HEIGHT;
    }

    protected void moveDown() {
        if (canMoveDown())
            setYPosition(getYPosition() + getSpeed());
    }

    protected boolean canMoveLeft() {
        return xPosition - speed > 0;
    }

    protected void moveLeft() {
        if (canMoveLeft()) {
            setXPosition(getXPosition() - getSpeed());
        }
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect((int) xPosition, (int) yPosition, (int) width, (int) height);
    }

    public KeyboardManager getKeyboardManager() {
        return keyboardManager;
    }

    public void setKeyboardManager(KeyboardManager keyboardManager) {
        this.keyboardManager = keyboardManager;
    }

    public float getXPosition() {
        return xPosition;
    }

    public void setXPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public void setYPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
