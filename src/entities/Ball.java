package entities;

import utilz.Constants.BALL;
import utilz.Constants.GAME_WINDOW;

import java.awt.*;

public class Ball extends Entity {

    private double xVelocity;
    private double yVelocity;

    public Ball(float xPosition, float yPosition, float width, float height, Color color, float speed) {
        super(xPosition, yPosition, width, height, color, speed);

        do {
            xVelocity = Math.random() * speed;
            yVelocity = Math.random() * speed;
            System.out.println(xVelocity + yVelocity);
        } while (xVelocity + yVelocity != speed);
    }

    public void update() {
        if (canMoveUp() && canMoveRight() && canMoveDown() && canMoveLeft()) {
            setXPosition(getXPosition() + (float) xVelocity);
            setYPosition(getYPosition() + (float) yVelocity);
        } else {
            xVelocity *= -1;
            yVelocity *= -1;
        }
        System.out.println("VETORIAL SPEED: x = " + xVelocity + "; y = " + yVelocity);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(BALL.COLOR);
        graphics.fillOval(
                (int) getXPosition(),
                (int) getYPosition(),
                (int) BALL.WIDTH,
                (int) BALL.HEIGHT);
    }
}
