package Model;

public class Container {

    private DataPoint[] dataPoints;
    private Centroid[] centroids;
    private int maxIterations;
    private IClustering clusteringMethod;
    private boolean elementsInPlace;

    public Container() {
        
    }

    public String startKMeans() {

        if(elementsInPlace) {
            clusteringMethod = new KMeans(dataPoints, centroids);
            return clusteringMethod.run(maxIterations);
        }
        return new String("Need more info.");
    }    

    public boolean getElementsInPlace() {
        return elementsInPlace;
    }

    public void setCentroids(Centroid[] centroids) {
        this.centroids = centroids;
        checkElementsInPlace();
    }
    public Centroid[] getCentroids() {
        return centroids;
    }
    public void setDataPoints(DataPoint[] dataPoints) {
        this.dataPoints = dataPoints;
        checkElementsInPlace();
    }
    public DataPoint[] getDataPoints() {
        return dataPoints;
    }
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
        checkElementsInPlace();
    }

    private void checkElementsInPlace() {

        this.elementsInPlace = false;
        if((dataPoints != null && dataPoints.length > 0) && 
           (centroids != null && centroids.length > 0) &&  
           (maxIterations > 0)) {
            
            this.elementsInPlace = true;
        }
    }
}