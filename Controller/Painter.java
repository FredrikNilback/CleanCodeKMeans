package Controller;

import Model.Centroid;
import Model.Container;
import View.Graph;
import Model.DataPoint;

public class Painter {

    Graph graph;
    Container container;
    private final int origoX = 2;
    private final int origoY = 497;
    private final int scale = 5;

    public Painter(Graph graph, Container container) {

        this.graph = graph;
        this.container = container;
    }

    public void paint(boolean centroids) {

        graph.flush();
        paintDataPoints();
        if (centroids) {
            paintCentroids();  
        }
    }

    public void firstPaint() {
        
        graph.flush();
        paintDataPoints();
    }

    private void paintDataPoints() {

        DataPoint[] dataPoints = container.getDataPoints();
        if(dataPoints.length == 0) {
            return;
        }
        
        for(int i = 0; i < dataPoints.length; i++) {

            DataPoint dataPoint = dataPoints[i];
            int dataPointX = dataPoint.getPositionX();
            int dataPointY = dataPoint.getPositionY();
            int dataPointColor = dataPoint.getColor();

            for (int x = -2; x < scale - 2; x++) {
                for (int y = -2; y < scale - 2; y++) {
                    
                    graph.setPixelColor(origoX + dataPointX * scale + x, origoY - dataPointY * scale + y, dataPointColor);
                }
            }
        }
    }

    private void paintCentroids() {
        
        Centroid[] centroids = container.getCentroids();
        for(int i = 0; i < centroids.length; i++) {
            
            Centroid centroid = centroids[i];
            int centroidX = centroid.getPositionX();
            int centroidY = centroid.getPositionY();
            int centroidColor = centroid.getColor();

            for(int x = -5; x < 6; x++) {
                for(int y = -5; y < 6; y++) {
                    
                    if(partOfCircle(x, y) && partOfCircumference(x, y)) {
                        graph.setPixelColor(origoX + centroidX * scale + x, origoY - centroidY * scale + y, 1);
                    }
                    else if (partOfCircle(x, y)) {
                        graph.setPixelColor(origoX + centroidX * scale + x, origoY - centroidY * scale + y, centroidColor);
                    }
                }
            }
        }
    }
    
    private boolean partOfCircle(int x, int y) {
        return x * x + y * y <= 25;
    }
    private boolean partOfCircumference(int x, int y) {
        return x * x + y * y <= 25 && x * x + y * y >= 10;
    }
}