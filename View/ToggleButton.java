package View;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class ToggleButton extends JToggleButton {

    public ToggleButton(int width, int height, int positionX, int positionY, String imagePath, String imagePathToggled) {

        setBounds(positionX, positionY, width, height);
        setIcon(new ImageIcon(imagePath));
        setSelectedIcon(new ImageIcon(imagePathToggled));
    }
}
