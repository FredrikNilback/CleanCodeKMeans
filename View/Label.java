package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel {

    ImageIcon icon;
    String imagePath1, imagePath2;

    public Label(int width, int height, int positionX, int positionY, String imagePath1, String imagePath2) {

        this.imagePath1 = imagePath1;
        this.imagePath2 = imagePath2;
        setBounds(positionX, positionY, width, height);
        icon = new ImageIcon(imagePath1);
        setIcon(icon);
    }

    public void switchIcon(boolean KMeans) {
        if (KMeans) {
            icon = new ImageIcon(imagePath1);
        }
        else {
            icon = new ImageIcon(imagePath2);
        }
        setIcon(icon);
    }
}