package View;

import javax.swing.JPanel;
import java.awt.Dimension;

public class Panel extends JPanel {

    private final int width = 1980;
    private final int height = 1080;

    public Panel() {

        Dimension dimension = new Dimension(width, height);
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
    }
}
