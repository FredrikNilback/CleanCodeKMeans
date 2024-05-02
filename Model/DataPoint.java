package Model;

public class DataPoint extends Element {

    public DataPoint(int x, int y) {
        super(x, y, 1);
    }

    public void setColor(int color) {
        this.color = color;
    }
}
