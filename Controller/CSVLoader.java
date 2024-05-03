package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Model.Container;
import Model.DataPoint;
import View.TextArea;

public class CSVLoader {

    private String path;
    private Container container;
    private TextArea outData;

    public CSVLoader(int CSVNumber, Container container, TextArea outData) {

        this.container = container;
        this.outData = outData;
        path = "Controller/DataPointTables/DataPoints" + CSVNumber + ".csv";
        loadCSV();
    }

    private void loadCSV() {
        
        ArrayList<DataPoint> dataPoints = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            
            String line;
            while((line = bufferedReader.readLine()) != null) {
                
                int posX = Integer.parseInt(line.split(",")[0]);
                int posY = Integer.parseInt(line.split(",")[1]);
                DataPoint dataPoint = new DataPoint(posX, posY);

                dataPoints.add(dataPoint);
                outData.setText("");
            }
        } 
        catch(Exception e) {
            outData.setText("No Array at that index!"); 
        }

        container.setDataPoints(dataPoints.toArray(new DataPoint[dataPoints.size()]));
    }
}