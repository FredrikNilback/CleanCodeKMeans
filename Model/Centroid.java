package Model;

import java.util.ArrayList;

public class Centroid extends Element {

    private ArrayList<DataPoint> dataPoints;
    private int lastPositionX, lastPositionY;
    private boolean moved = true; 

    public Centroid(int x, int y, int color) {
        super(x, y, color);
    }

    public void moveCentroid(int x, int y) {

        this.moved = true;
        if (lastPositionX == x && lastPositionY == y) {
            this.moved = false;
        }
        this.lastPositionX = positionX;
        this.lastPositionY = positionY;
        this.positionX = x;
        this.positionY = y;

    }

    public void addDataPoint(DataPoint dataPoint) {

        dataPoints.add(dataPoint);
        dataPoint.setColor(this.color);
    }

    public boolean getMoved() {
        return moved;
    }

    public DataPoint[] getDataPoints() {
        return dataPoints.toArray(new DataPoint[dataPoints.size()]);
    }

}
