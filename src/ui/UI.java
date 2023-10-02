package ui;

import main.Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class UI {

    public static class Button implements MouseListener, MouseMotionListener {

        private Game game;
        private int x;
        private int y;
        private int width;
        private int height;
        private String text;
        private Color color;
        private float fontSize;
        private Rectangle buttonBox;
        private int fontWidth;
        private int fontHeight;
        private boolean isPressed = false;
        private boolean mouseIsOver = false;
        private Color textColor;
        private Color foregroundColor;

        public Button(Game game, int x, int y, String text, Color textColor, Color foregroundColor, float fontSize) {
            this.game = game;
            this.x = x;
            this.y = y;
            this.text = text;
            this.textColor = textColor;
            this.foregroundColor = foregroundColor;
            this.fontSize = fontSize;
        }

        public Button(Game game, int x, int y, int width, int height) {
            this.game = game;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            buttonBox = new Rectangle(x, y, width, height);
        }

        public void draw(Graphics graphics) {
            buttonBox = new Rectangle((x - fontWidth / 2) - 4, (y - (fontHeight)) - 4, fontWidth + 9, fontHeight + 10);
            if (mouseIsOver) {
                graphics.setColor(Color.WHITE);
            } else {
                graphics.setColor(foregroundColor);
            }
            graphics.fillRect((x - fontWidth / 2) - 4, (y - (fontHeight)) - 4, fontWidth + 9, fontHeight + 10);
            graphics.setColor(textColor);
            graphics.setFont(graphics.getFont().deriveFont(Font.BOLD, fontSize));
            fontWidth = graphics.getFontMetrics().stringWidth(text);
            fontHeight = graphics.getFontMetrics().getMaxAscent() - graphics.getFontMetrics().getDescent();
            graphics.drawString(text, x - fontWidth / 2, y);
            graphics.drawRect(buttonBox.x, buttonBox.y, buttonBox.width, buttonBox.height);
        }

        public void setText(String text) {
            this.text = text;
        }

        public Rectangle getButtonBox() {
            return buttonBox;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("Entered");
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        public void setMouseIsOver(boolean mouseIsOver) {
            this.mouseIsOver = mouseIsOver;
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseIsOver = true;
        }
    }

}
