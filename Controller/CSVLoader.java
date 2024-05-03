package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Model.Container;
import Model.DataPoint;

public class CSVLoader {

    private String path;
    private Container container;

    public CSVLoader(int CSVNumber, Container container) {

        this.container = container;
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
            }
        } 
        catch(Exception e) {
            System.out.println("No array at that index"); 
        }

        container.setDataPoints(dataPoints.toArray(new DataPoint[dataPoints.size()]));
    }
}