package data;

/**
 * Class for study group coordinates
 */
public class Coordinates {
    private final int x;
    private final double y;

    /**
     * Class constructor
     *
     * @param aX - first coordinate
     * @param aY - second coordinate
     */
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
    public String toString() {
        return getX() + ", " + getY();
    }
}
