package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class for study group admin
 */
@XmlType(propOrder = {"name", "weight", "hairColor"})
public class Person {
    private String name;
    private long weight;
    private Color hairColor;

    /**
     * Class constructor
     * @param aName - admin name
     * @param aWeight - admin weight
     * @param aHairColor - admin color
     */
    public Person(String aName, long aWeight, Color aHairColor) {
        name = aName;
        weight = aWeight;
        hairColor = aHairColor;
    }

    @XmlElement
    public void setName(String aName){
        name = aName;
    }

    @XmlElement
    public void setWeight(long aWeight){
        weight = aWeight;
    }

    @XmlElement
    public void setHairColor(Color aHairColor){
        hairColor = aHairColor;
    }

    public String getName() {
        return name;
    }

    public long getWeight() {
        return weight;
    }

    public Color getHairColor() {
        return hairColor;
    }

    @Override
    public String toString(){
        return "name = " + name + ", " +
                "weight = " + weight + ", " +
                "hair color = " + hairColor;
    }
}
