package ui;

import main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class UI {

    public static class Button {

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

        public Button(Game game, int x, int y, int width, int height, String text, Color color, float fontSize) {
            this.game = game;
            this.x = x;
            this.y = y;
            this.text = text;
            this.width = width;
            this.height = height;
            this.color = color;
            this.fontSize = fontSize;
            buttonBox = new Rectangle(x - (width / 2), y - (int) fontSize, width, height);
        }

        public void draw(Graphics graphics) {
            graphics.setColor(Color.WHITE);
            graphics.fillRect(x - fontWidth / 2, y - (fontHeight), fontWidth, fontHeight);
            graphics.setColor(color);
            graphics.setFont(graphics.getFont().deriveFont(Font.BOLD, fontSize));
            fontWidth = graphics.getFontMetrics().stringWidth(text);
            fontHeight = graphics.getFontMetrics().getMaxAscent() - graphics.getFontMetrics().getDescent();
            graphics.drawString(text, x - fontWidth / 2, y);
        }

        public void setText(String text) {
            this.text = text;
        }

        public Rectangle getButtonBox() {
            return buttonBox;
        }
    }

}
