package data;

public class Coordinates {
    private int x;
    private double y;

    public Coordinates(int aX, double aY) {
        x = aX;
        y = aY;
    }

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString(){
        return getX() + ", " + getY();
    }
}
