package inputs;

import gamestates.Gamestate;
import main.GamePanel;
import ui.Language;
import ui.Languages;
import static ui.Languages.*;

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
            } else if (gamePanel.getGame().getMainMenu().getQuit().getButtonBox().contains(e.getX(), e.getY())) {
                System.exit(0);
            } else if (gamePanel.getGame().getMainMenu().getBrazilButton().getButtonBox().contains(e.getX(), e.getY())) {
                gamePanel.getGame().setGameLanguage(new Languages(Language.ptBR));
                gamePanel.getGame().getMainMenu().getPlay().setText(PTBR_PLAY_BUTTON_TEXT);
                gamePanel.getGame().getMainMenu().getQuit().setText(PTBR_EXIT_BUTTON_TEXT);
                System.out.println("BRAZIL!");
            } else if (gamePanel.getGame().getMainMenu().getUsaButton().getButtonBox().contains(e.getX(), e.getY())) {
                gamePanel.getGame().setGameLanguage(new Languages(Language.enUS));
                gamePanel.getGame().getMainMenu().getPlay().setText(ENUS_PLAY_BUTTON_TEXT);
                gamePanel.getGame().getMainMenu().getQuit().setText(ENUS_EXIT_BUTTON_TEXT);
                System.out.println("USA!");
            }
        } else if (gamePanel.getGame().getGamestate() == Gamestate.PAUSED) {
            if (gamePanel.getGame().getPaused().getResumeButton().getButtonBox().contains(e.getX(), e.getY())) {
                gamePanel.getGame().setGamestate(Gamestate.PLAYING);
            } else if (gamePanel.getGame().getPaused().getRestartButton().getButtonBox().contains(e.getX(), e.getY())) {
                gamePanel.getGame().restartGame();
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
