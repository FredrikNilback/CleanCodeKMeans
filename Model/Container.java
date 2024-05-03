package Model;

public class Container {

    private DataPoint[] dataPoints;
    private Centroid[] centroids;
    private int maxIterations, minimumPoints, epsilon;
    private IClustering clusteringMethod;
    private boolean KMeansElementsInPlace, DBSCANElementsInPlace;

    public Container() {
        
    }

    public String startClustering(boolean KMeans) {

        if(KMeansElementsInPlace && KMeans) {

            clusteringMethod = new KMeans(dataPoints, centroids);
            return clusteringMethod.run(maxIterations);
        }
        else if(DBSCANElementsInPlace && !KMeans) {

            clusteringMethod = new DBSCAN(dataPoints, minimumPoints);
            return clusteringMethod.run(epsilon);
        }
        return new String("Need more info.");
    }    

    public void setCentroids(Centroid[] centroids) {
        this.centroids = centroids;
        checkKMeansElementsInPlace();
    }
    public Centroid[] getCentroids() {
        return centroids;
    }
    public void setDataPoints(DataPoint[] dataPoints) {
        this.dataPoints = dataPoints;
        checkKMeansElementsInPlace();
    }
    public DataPoint[] getDataPoints() {
        return dataPoints;
    }
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
        checkKMeansElementsInPlace();
    }
    public void setEpsilon(int epsilon) {
        this.epsilon = epsilon;
        checkDBSCANElementsInPlace();
    }
    public void setMinimumPoints(int minimumPoints) {
        this.minimumPoints = minimumPoints;
        checkDBSCANElementsInPlace();
    }

    private void checkKMeansElementsInPlace() {

        this.KMeansElementsInPlace = false;
        this.DBSCANElementsInPlace = false;
        if((dataPoints != null && dataPoints.length > 0) && 
           (centroids != null && centroids.length > 0) &&  
           (maxIterations > 0)) {
            
            this.KMeansElementsInPlace = true;
        }
    }

    private void checkDBSCANElementsInPlace() {

        this.KMeansElementsInPlace = false;
        this.DBSCANElementsInPlace = false;
        if((dataPoints != null && dataPoints.length > 0) &&
           (epsilon > 0 && minimumPoints > 0)) {
            this.DBSCANElementsInPlace = true;
        }
    }   
}