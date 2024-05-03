package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {

    public Button(int width, int height, int positionX, int positionY, String imagePath) {

        setBounds(positionX, positionY, width, height);
        setIcon(new ImageIcon(imagePath));
    }

    public Button(int width, int height, int positionX, int positionY, int number) {

        setBounds(positionX, positionY, width, height);
        setText("" + number);
    }
}