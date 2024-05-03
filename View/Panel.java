package View;

import javax.swing.JPanel;
import java.awt.Dimension;

public class Panel extends JPanel {

    private final int width = 1000;
    private final int height = 1000;

    private Graph graph = new Graph();
    private Button startButton;
    private Button[] arrayPickers = new Button[18];
    private TextArea kInput, maxIterations, outData;
    private Label axis;

    public Panel() {

        Dimension dimension = new Dimension(width, height);
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setLayout(null);
        add(graph);
        addAxis();
        addTextAreas();
        addButtons();
    }

    private void addAxis() {

        axis = new Label(790, 542, 220, 0, "View/Images/Axis.png");
        add(axis);
    }

    private void addTextAreas() {

        kInput = new TextArea(32, 32, 800, 100, true);
        add(kInput);
        maxIterations = new TextArea(32, 32, 918, 100, true);
        add(maxIterations);
        outData = new TextArea(800, 400, 100, 575, false);
        add(outData);
    }

    private void addButtons() {

        startButton = new Button(128, 64, 811, 500, "View/Images/StartButton.png");
        add(startButton);

        final int buttonSize = 48;
        int column = 0;
        int row = 0;
        for(int i = 1; i < arrayPickers.length + 1; i++) {

            arrayPickers[i - 1] = new Button(buttonSize, buttonSize, column * 50 + 800, row * 50 + 170, i);
            column++;
            if(column % 3 == 0) {

                row++;
                column = 0;
            }

            add(arrayPickers[i - 1]);
        }  
    }

    public Graph getGraph() {
        return graph;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button[] getArrayPickers() {
        return arrayPickers;
    }

    public int getK() {
        int k = Integer.parseInt(kInput.getText());
        return k;
    }

    public int getMaxIterations() {
        int iterations = Integer.parseInt(maxIterations.getText());
        return iterations;
    }

    public TextArea getOutData() {
        return outData;
    }
}