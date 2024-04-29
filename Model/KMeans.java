package Model;

import java.util.Random;

public class KMeans {

    DataPoint[] dataPoints;
    Centroid[] centroids;

    public KMeans(DataPoint[] dataPoints, Centroid[] centroids, int maxIterations) {

        this.dataPoints = dataPoints;
        this.centroids = centroids;
        run(maxIterations);
    }

    private String run(int maxIterations) {

        for (int i = 0; i < maxIterations; i++) {
            
            assignDataToCentroids();
            setNewCentroidPosition();
            if(!checkCentroidMoved()) {
                break;
            }
        }

        String output = makeString();
        return output;
    }

    private void assignDataToCentroids() {

        for(int i = 0; i < dataPoints.length; i++) {

            double minimumDistance = Double.POSITIVE_INFINITY;
            int closestCentroidIndex = -1; 
            int dataX = dataPoints[i].getPositionX(), dataY = dataPoints[i].getPositionY();
            for(int j = 0; j < centroids.length; j++) {
                
                int centroidX = centroids[i].getPositionX(), centroidY = centroids[i].getPositionY();
                double distance = Math.sqrt((dataX + centroidX) * (dataX + centroidX) + (dataY + centroidY) * (dataY + centroidY));
                if(distance < minimumDistance) {
                    
                    minimumDistance = distance;
                    closestCentroidIndex = j;
                }
            }

            centroids[closestCentroidIndex].addDataPoint(dataPoints[i]);
        }
    }

    private void setNewCentroidPosition() {

        for(int i = 0; i < centroids.length; i++) {

            DataPoint[] dataPointsInCentroid = centroids[i].getDataPoints();
            
            if(dataPointsInCentroid.length == 0) {

                Random random = new Random();
                centroids[i].moveCentroid(random.nextInt(100), random.nextInt(100));
                continue;
            }

            int xSum = 0;
            int ySum = 0;

            for(int j = 0; j < dataPointsInCentroid.length; j++) {
                
                xSum += dataPointsInCentroid[j].getPositionX();
                ySum += dataPointsInCentroid[j].getPositionY();
            }

            double xAverage = (double) xSum / dataPointsInCentroid.length;
            double yAverage = (double) ySum / dataPointsInCentroid.length;

            centroids[i].moveCentroid((int) Math.round(xAverage), (int) Math.round(yAverage));
        }
    }

    private boolean checkCentroidMoved() {

        for(int i = 0; i < centroids.length; i++) {
            if(centroids[i].getMoved()) {
                return true;
            }
        }
        return false;
    }

    private String makeString() {

        String output = "";
        for (int i = 0; i < centroids.length; i++) {

            output += "Centroid " + (i + 1) + ": ";
            DataPoint[] dataPointsInCentroid = centroids[i].getDataPoints();
            for (int j = 0; j < dataPointsInCentroid.length - 1; j++) {
                output += "[" + dataPointsInCentroid[j].getPositionX() + ", " + dataPointsInCentroid[j].getPositionY() + "], ";
            }
            output += "[" + dataPointsInCentroid[dataPointsInCentroid.length - 1].getPositionX() + ", " + dataPointsInCentroid[dataPointsInCentroid.length - 1].getPositionY() + "]\n";
        }

        return output;
    }
    
}
