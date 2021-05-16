package data;

public class Coordinates {
    private final int x;
    private final double y;

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
