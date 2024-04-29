package Model;

public class Element {

    protected int positionX;
    protected int positionY;
    protected int color;

    public Element(int x, int y, int color) {

        this.positionX = x;
        this.positionY = y;
        this.color = color;
    }

    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public int getColor() {
        return color;
    }
}
