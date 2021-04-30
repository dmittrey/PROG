import aliveInterface.Person;

/**
 *
 * Класс строений
 *
 * Создан для дома Кристофера Робина
 *
 */

public class Place {
    private Person owner;
    private String type;

    public Place(Person aOwner, String aType){
        owner = aOwner;
        type = aType;
    }

    public void setOwner(Person aOwner){
        owner = aOwner;
    }

    public Person getOwner(){
        return owner;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString(){
        return "at " + type + " belonging to a " + owner;
    }
}
