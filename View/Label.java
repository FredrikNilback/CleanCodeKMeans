package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel {

    public Label(int width, int height, int positionX, int positionY, String imagePath) {

        setBounds(positionX, positionY, width, height);
        setIcon(new ImageIcon(imagePath));
    }
}
