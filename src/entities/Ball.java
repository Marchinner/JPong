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

    /***
     * Creates a 'Ball' entity
     * @param xPosition the starting 'x' position of the ball
     * @param yPosition the starting 'y' position of the ball
     * @param width the width of the ball
     * @param height the height of the ball
     * @param color the color of the ball
     * @param speed the speed of the ball
     * @param keyboardManager the keyboardManager class (null in this case)
     * @param player the player entity
     * @param enemy the enemy entity
     * @param name the name of the entity
     * @param gameScore the score of the game
     */
    public Ball(float xPosition, float yPosition, float width, float height, Color color, float speed,
                KeyboardManager keyboardManager, Player player,
                Enemy enemy, String name, Score gameScore) {
        super(xPosition, yPosition, width, height, color, speed, keyboardManager, name);
        this.player = player;
        this.enemy = enemy;
        this.gameScore = gameScore;

        generateInitialVelocity();
    }

    /***
     * Generate the initial x and y velocity by a random pseudo value
     */
    private void generateInitialVelocity() {
        do {
            xVelocity = (Math.random() * getSpeed()) - getSpeed();
            yVelocity = (Math.random() * getSpeed()) - getSpeed();
        } while (xVelocity + yVelocity > getSpeed() && xVelocity + getYPosition() < -getSpeed());
    }

    /***
     * Updates the ball
     */
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

    /***
     * Verify if the ball touched some of the paddles
     * @param paddle the paddle of the entity (enemy or player)
     * @return return true or false if it hits the paddle
     */
    private boolean touchedPaddle(Entity paddle) {
        if (isOnPaddleRange(paddle)) {
            if (getYPosition() >= paddle.getYPosition() && getYPosition() <= paddle.getYPosition() + paddle.getHeight()) {
                hit();
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    /***
     * Increases the speed of the ball by 'HIT_BONUS_SPEED' constant when it hits the paddles
     */
    private void hit() {
        xVelocity *= BALL.HIT_BONUS_SPEED;
        yVelocity *= BALL.HIT_BONUS_SPEED;
    }

    /***
     * Verify if the paddle is on 'x' range of the ball
     * @param paddle the paddle entity (enemy or player)
     * @return return true if the paddle is on the range of the ball
     */
    private boolean isOnPaddleRange(Entity paddle) {
        if (paddle.name.equals("player")) {
            return getXPosition() <= paddle.getXPosition() + paddle.getWidth();
        } else {
            return getXPosition() >= paddle.getXPosition() - paddle.getWidth();
        }
    }

    /***
     * Moves the ball depending on the x and y velocity
     */
    private void moveBall() {
        setXPosition(getXPosition() + (float) xVelocity);
        setYPosition(getYPosition() + (float) yVelocity);
    }

    /***
     * Draw's the ball
     * @param graphics the graphics
     */
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
