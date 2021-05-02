package data;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long weight; //Поле не может быть null, Значение поля должно быть больше 0
    private Color hairColor; //Поле не может быть null

    public Person(String aName, Long aWeight, Color aHairColor) {
        name = aName;
        weight = aWeight;
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
}
