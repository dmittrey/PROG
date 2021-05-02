package data;

public class Coordinates {
    private int x;
    private Double y; //Поле не может быть null

    public Coordinates(int aX, Double aY) {
        x = aX;
        y = aY;
    }

    public int getX() {
        return x;
    }

    public Double getY() {
        return y;
    }
}
