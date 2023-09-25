package ui;

import java.awt.*;

public class UI {

    public static class Button {

        private int x;
        private int y;
        private int width;
        private int height;
        private String text;
        private Color color;
        private float fontSize;
        private Rectangle buttonBox;

        public Button(int x, int y, int width, int height, String text, Color color, float fontSize) {
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
            graphics.fillRect(x - (width / 2), y - (int) fontSize, width, height);
            graphics.setColor(color);
            graphics.setFont(graphics.getFont().deriveFont(Font.BOLD, fontSize));
            graphics.drawString(text, x - (width / 2), y);
        }

        public Rectangle getButtonBox() {
            return buttonBox;
        }
    }

}
