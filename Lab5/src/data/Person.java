package data;

/**
 * Class for study group admin
 */
public class Person {
    private final String name;
    private final long weight;
    private final Color hairColor;

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
