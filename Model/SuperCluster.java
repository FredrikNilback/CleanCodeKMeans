package Model;

public abstract class SuperCluster {

    protected DataPoint[] dataPoints;
    
    public SuperCluster(DataPoint[] dataPoints) {
        this.dataPoints = dataPoints;
    }

    protected abstract String makeString();
}
