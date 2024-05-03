package Model;

public class DataPoint extends Element {

    private boolean used;

    public DataPoint(int x, int y) {
        super(x, y, 1);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    public boolean isUsed() {
        return used;
    }
}