package entities;

import inputs.KeyboardManager;
import main.Score;
import utilz.Constants.BALL;

import java.awt.*;

public class Ball extends Entity {

    private double xVelocity;
    private double yVelocity;
    private Player player;
    private Enemy enemy;
    private Score gameScore;

    public Ball(float xPosition, float yPosition, float width, float height, Color color, float speed,
                KeyboardManager keyboardManager, Player player,
                Enemy enemy, String name, Score gameScore) {
        super(xPosition, yPosition, width, height, color, speed, keyboardManager, name);
        this.player = player;
        this.enemy = enemy;
        this.gameScore = gameScore;

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
            if (touchedPaddle(player) || touchedPaddle(enemy)) {
                xVelocity *= -1;
                moveBall();
            }
        } else {
            if (!canMoveUp() || !canMoveDown()) {
                yVelocity *= -1;
                moveBall();
            } else if (!canMoveRight() || !canMoveLeft()) {
                if (!canMoveRight()) {
                    gameScore.setPlayerScore(gameScore.getPlayerScore() + 1);
                } else if (!canMoveLeft()) {
                    gameScore.setEnemyScore(gameScore.getEnemyScore() + 1);
                }
                xVelocity *= -1;
                moveBall();
            }
        }
    }

    private boolean touchedPaddle(Entity paddle) {
        if (isOnPaddleRange(paddle)) {
            if (getYPosition() >= paddle.getYPosition() && getYPosition() <= paddle.getYPosition() + paddle.getHeight()) {
                System.out.println("TOUCHED " + paddle.name + "!");
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    private boolean isOnPaddleRange(Entity paddle) {
        if (paddle.name.equals("player")) {
            return getXPosition() <= paddle.getXPosition() + paddle.getWidth();
        } else {
            return getXPosition() >= paddle.getXPosition() - paddle.getWidth();
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
