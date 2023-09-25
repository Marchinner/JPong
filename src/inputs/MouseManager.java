package inputs;

import gamestates.Gamestate;
import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private GamePanel gamePanel;

    public MouseManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (gamePanel.getGame().getGamestate() == Gamestate.MAIN_MENU) {
            if (gamePanel.getGame().getMainMenu().getPlay().getButtonBox().contains(e.getX(), e.getY())) {
                gamePanel.getGame().setGamestate(Gamestate.PLAYING);
            }
            if (gamePanel.getGame().getMainMenu().getQuit().getButtonBox().contains(e.getX(), e.getY())) {
                System.exit(0);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
