package entities;

import utilz.Constants.BALL;

import java.awt.*;

public class Ball extends Entity {

    private double xVelocity;
    private double yVelocity;
    private Player player;
    private Enemy enemy;

    public Ball(float xPosition, float yPosition, float width, float height, Color color, float speed, Player player,
                Enemy enemy) {
        super(xPosition, yPosition, width, height, color, speed);
        this.player = player;
        this.enemy = enemy;

        generateInitialVelocity();
    }

    private void generateInitialVelocity() {
        do {
            xVelocity = (Math.random() * getSpeed()) - getSpeed();
            yVelocity = (Math.random() * getSpeed()) - getSpeed();
        } while (xVelocity + yVelocity > getSpeed() && xVelocity + getYPosition() < -getSpeed());
    }

    public void update() {
        if (canMoveUp() && canMoveRight() && canMoveDown() && canMoveLeft()) {
            moveBall();
        } else {
            if (!canMoveUp() || !canMoveDown()) {
                yVelocity *= -1;
                moveBall();
            } else if (!canMoveRight() || !canMoveLeft()) {
                xVelocity *= -1;
                moveBall();
            }
        }
        touchedPlayerPaddle(player);
    }

    private boolean touchedPlayerPaddle(Player player) {
        if (getXPosition() <= player.getXPosition() + player.getWidth()) {
            if (getHeight() > player.getYPosition() && getHeight() < player.getYPosition() + player.getHeight()) {
                System.out.println("TOUCHED PLAYER");
                return true;
            } else {
                System.out.println("ALMOST");
                return false;
            }
        } else {
            return false;
        }
    }

    private void moveBall() {
        setXPosition(getXPosition() + (float) xVelocity);
        setYPosition(getYPosition() + (float) yVelocity);
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
