package main;

import utilz.Constants;

import java.awt.*;

public class Score {

    private int playerScore = 0;
    private int enemyScore = 0;

    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawRect(Constants.GAME_WINDOW.WIDTH / 2, 0, 1, Constants.GAME_WINDOW.HEIGHT);
        graphics2D.setFont(graphics2D.getFont().deriveFont(25f));
        graphics2D.setColor(Color.RED);
        graphics2D.drawString("Jogador", 150, 30);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Integer.toString(playerScore), 350, 30);
        graphics2D.drawString(Integer.toString(enemyScore), Constants.GAME_WINDOW.WIDTH - 370, 30);
        graphics2D.setColor(Color.BLUE);
        graphics2D.drawString("Computador", Constants.GAME_WINDOW.WIDTH - 250, 30);
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getEnemyScore() {
        return enemyScore;
    }

    public void setEnemyScore(int enemyScore) {
        this.enemyScore = enemyScore;
    }
}
