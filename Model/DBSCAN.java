package Model;

import java.util.ArrayList;

import View.ColorSelector;

public class DBSCAN extends SuperCluster implements IClustering {
    
    private ArrayList<DataPoint> coreDataPoints;
    private ArrayList<ArrayList<DataPoint>> clusters;
    private int[] clusterSizes;
    private int minimumPoints;

    public DBSCAN(DataPoint[] dataPoints, int minimumPoints){

        super(dataPoints);
        this.minimumPoints = minimumPoints;
    }

    @Override
    public String run(int epsilon) {

        reset();
        identifyCorePoints(epsilon);
        resetUsed();
        while(true) {

            expandCluster(epsilon);
            if(checkDoneGrowing()) {
                break;
            }
        }

        String output = makeString();
        return output;
    }

    private void identifyCorePoints(int epsilon) {

        int color = 2;
        for(int i = 0; i < dataPoints.length; i++) {

            DataPoint dataPoint = dataPoints[i];
            int dataPointX = dataPoint.getPositionX();
            int dataPointY = dataPoint.getPositionY();
            ArrayList<DataPoint> closeDataPoints = new ArrayList<>();

            for(int j = 0; j < dataPoints.length; j++) {
                
                DataPoint dataPointToCompare = dataPoints[j];

                if(j == i || dataPointToCompare.isUsed()) {
                    continue;
                }

                double distance = Math.sqrt((dataPointX - dataPointToCompare.getPositionX()) *
                                            (dataPointX - dataPointToCompare.getPositionX()) + 
                                            (dataPointY - dataPointToCompare.getPositionY()) * 
                                            (dataPointY - dataPointToCompare.getPositionY()));

                if(distance <= epsilon) {
                    closeDataPoints.add(dataPointToCompare);
                }
            }

            if(closeDataPoints.size() >= minimumPoints) {

                dataPoint.setColor(color);
                coreDataPoints.add(dataPoint);
                clusters.add(new ArrayList<>());
                clusters.get(color - 2).add(dataPoint);

                for (int j = 0; j < closeDataPoints.size(); j++) {
                    closeDataPoints.get(j).setUsed(true);
                }
                color++;
            }
        }

        this.clusterSizes = new int[clusters.size()];

        for (int i = 0; i < clusterSizes.length; i++) {
            clusterSizes[i] = clusters.get(i).size();
        }
    }

    private void expandCluster(int epsilon) {

        for(int i = 0; i < clusters.size(); i++) {

            ArrayList<DataPoint> dataPointsInCluster = clusters.get(i);
            ArrayList<DataPoint> newPoints = new ArrayList<>();
        
            for(int j = 0; j < dataPointsInCluster.size(); j++) {

                DataPoint corePoint = dataPointsInCluster.get(j);
                int corePointX = corePoint.getPositionX();
                int corePointY = corePoint.getPositionY();
                int color = corePoint.getColor();
        
                for(int k = 0; k < dataPoints.length; k++) {

                    DataPoint neighbor = dataPoints[k];
                    if(!neighbor.isUsed()) {
                        double distance = Math.sqrt((corePointX - neighbor.getPositionX()) * (corePointX - neighbor.getPositionX()) +
                                                    (corePointY - neighbor.getPositionY()) * (corePointY - neighbor.getPositionY()));
        
                        if(distance <= epsilon) {
                            neighbor.setUsed(true);
                            neighbor.setColor(color);
                            newPoints.add(neighbor);
                        }
                    }
                }
            }
            dataPointsInCluster.addAll(newPoints);
        }
    }

    private boolean checkDoneGrowing() {

        boolean done = true;
        for(int i = 0; i < clusterSizes.length; i++) {
            
            if(clusterSizes[i] != clusters.get(i).size()) {

                clusterSizes[i] = clusters.get(i).size();
                done = false;
            }
        }

        return done;
    }

    private void resetUsed() {

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i].setUsed(false);
        }
    }

    private void reset() {

        this.coreDataPoints = new ArrayList<>();
        this.clusters = new ArrayList<>();

        for(int i = 0; i < dataPoints.length; i++) {

            dataPoints[i].setColor(1);
            dataPoints[i].setUsed(false);
        }
    }

    @Override
    protected String makeString() {
        String output = "";

        ArrayList<ArrayList<DataPoint>> colorSeparation = new ArrayList<>();
        ArrayList<Integer> usedColors = new ArrayList<>(1);

        for(int i = 0; i < dataPoints.length; i++) {
            DataPoint dataPoint = dataPoints[i];
            int color = dataPoint.getColor();
        
            if(!usedColors.contains(color)) {
                usedColors.add(color);
                colorSeparation.add(new ArrayList<>());
            }
        
            int colorIndex = usedColors.indexOf(color);
            colorSeparation.get(colorIndex).add(dataPoint);
        }

        for (int i = 0; i < colorSeparation.size(); i++) {

            int color = colorSeparation.get(i).get(0).getColor();
            output += ColorSelector.getColorName(color);
            if (color == 1) {
                output += " (Outliers):\n";
            }
            else {
                output += " Cluster:\n";
            }

            for (int j = 0; j < colorSeparation.get(i).size() - 1; j++) {

                DataPoint dp = colorSeparation.get(i).get(j);
                output += "[" + dp.getPositionX() + ", " + dp.getPositionY() + "], ";
                if (j % 16 == 0 && j != 0) {
                    output += "\n";
                }
            }

            output += "[" + colorSeparation.get(i).get(colorSeparation.get(i).size() -1).getPositionX() + ", " + colorSeparation.get(i).get(colorSeparation.get(i).size() -1).getPositionY() + "]\n";
        }

        return output;
    }
}