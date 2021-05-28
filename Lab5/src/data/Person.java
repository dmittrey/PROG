package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class for study group admin
 */
@XmlType(propOrder = {"name", "weight", "hairColor"})
public class Person {
    private String name;
    private Long weight;
    private Color hairColor;

    /**
     * Class constructor
     *
     * @param aName - admin name
     * @param aWeight - admin weight
     * @param aHairColor - admin color
     */
    public Person(String aName, Long aWeight, Color aHairColor) {
        name = aName;
        weight = aWeight;
        hairColor = aHairColor;
    }

    /**
     * Class constructor for Xml parser
     */
    public Person(){
        name = null;
        weight = null;
        hairColor = null;
    }

    @XmlElement
    public void setName(String aName){
        name = aName;
    }

    @XmlElement
    public void setWeight(Long aWeight){
        weight = aWeight;
    }

    @XmlElement
    public void setHairColor(Color aHairColor){
        hairColor = aHairColor;
    }

    public String getName() {
        return name;
    }

    public Long getWeight() {
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
