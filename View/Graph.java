package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Graph extends JLabel {

    private int[][] pixels;
    private final int width = 800;
    private final int height = 800;

    public Graph() {
        setPreferredSize(new Dimension(width, height));
    }

    public void setPixelColor(int x, int y, int color) {

        pixels[x][y] = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels.length; y++) {
                
                Color color = ColorSelector.getColor(pixels[x][y]);
                g.setColor(color);
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}
