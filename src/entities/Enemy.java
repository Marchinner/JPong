package entities;

import java.awt.*;

public class Enemy extends Entity {

    private Ball ball;

    public Enemy(float xPosition, float yPosition, float width, float height, Color color, float speed, Ball ball) {
        super(xPosition, yPosition, width, height, color, speed);
        this.ball = ball;
    }

    public void update() {
        if (ball.getYPosition() > getYPosition() + getHeight() / 2) {
            moveDown();
        } else if (ball.getYPosition() < getYPosition() + getHeight() / 2) {
            moveUp();
        }
    }
}
