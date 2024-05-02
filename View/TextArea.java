package View;

import javax.swing.JTextArea;

public class TextArea extends JTextArea {

    public TextArea(int width, int height, int positionX, int positionY, boolean editable) {

        setBounds(positionX, positionY, width, height);
        setEditable(editable);
        
    }
}
