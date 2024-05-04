package View;

import javax.swing.JPanel;
import java.awt.Dimension;

public class Panel extends JPanel {

    private final int width = 1000;
    private final int height = 1000;

    private Graph graph = new Graph();
    private Button startButton;
    private Button[] arrayPickers = new Button[18];
    private ToggleButton KMeansButton, DBSCANButton;
    private TextArea input1, input2, outData;
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

        axis = new Label(790, 542, 220, 0, "View/Images/AxisKMeans.png", "View/Images/AxisDBSCAN.png");
        add(axis);
    }

    private void addTextAreas() {

        final int inputSize = 32;
        input1 = new TextArea(inputSize, inputSize, 800, 100, true);
        add(input1);
        input2 = new TextArea(inputSize, inputSize, 918, 100, true);
        add(input2);
        outData = new TextArea(800, 400, 100, 575, false);
        add(outData);
    }

    private void addButtons() {

        final int buttonWidth = 128;
        final int buttonHeight = 64;

        startButton = new Button(buttonWidth, buttonHeight, 811, 500, "View/Images/StartButton.png");
        add(startButton);

        KMeansButton = new ToggleButton(buttonWidth, buttonHeight, 50, 50, "View/Images/KMeansButton.png", "View/Images/KMeansButtonPressed.png");
        KMeansButton.setSelected(true);
        add(KMeansButton);

        DBSCANButton = new ToggleButton(buttonWidth, buttonHeight, 50, 150, "View/Images/DBSCANButton.png", "View/Images/DBSCANButtonPressed.png");
        add(DBSCANButton);

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

    //Getters

    public Graph getGraph() {
        return graph;
    }

    public Label getAxis() {
        return axis;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button[] getArrayPickers() {
        return arrayPickers;
    }

    public String getInput1() {
        return input1.getText();
    }
    public String getInput2() {
        return input2.getText();
    }

    public TextArea getOutData() {
        return outData;
    }

    public ToggleButton getDBSCANButton() {
        return DBSCANButton;
    }
    public ToggleButton getKMeansButton() {
        return KMeansButton;
    }
}