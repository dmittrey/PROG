package data;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long weight; //Поле не может быть null, Значение поля должно быть больше 0
    private Color hairColor; //Поле не может быть null

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
