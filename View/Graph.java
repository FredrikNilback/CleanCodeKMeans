package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Graph extends JLabel {

    private int[][] pixels;
    private final int width = 500;
    private final int height = 500;

    public Graph() {

        setPreferredSize(new Dimension(width, height));
        setBounds(250, 20, width, height);
        pixels = new int[width][height];
    }

    public void setPixelColor(int x, int y, int color) {

        if (x < 0 || x >= width || y < 0 || y >= height) {
            return;
        }
        pixels[x][y] = color;
        repaint();
    }

    public void flush() {
        pixels = new int[width][height];
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for(int x = 0; x < pixels.length; x++) {
            for(int y = 0; y < pixels[x].length; y++) {
                
                Color color = ColorSelector.getColor(pixels[x][y]);
                g.setColor(color);
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}
