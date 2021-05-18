package data;

import javax.xml.bind.annotation.XmlElement;

/**
 * Class for study group coordinates
 */
public class Coordinates {
    private int x;
    private double y;

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

    /**
     * Class constructor for Xml parser
     */
    public Coordinates(){
        x = 0;
        y = 0;
    }

    @XmlElement(name = "CoordinateX")
    public void setX(int aX){
        x = aX;
    }

    @XmlElement (name = "CoordinateY")
    public void setY(double aY) {
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
