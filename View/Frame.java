package View;



import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame(Panel panel) {

        
        setResizable(false);
        add(panel);
        pack();
        setVisible(true);
    }
}
