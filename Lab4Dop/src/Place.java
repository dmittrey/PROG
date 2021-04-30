import aliveInterface.AllAllAll;
import aliveInterface.Person;

import java.util.Objects;

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
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Place other = (Place) otherObject;

        return owner.equals(other.owner)
                && type.equals(other.type);
    }

    @Override
    public String toString(){
        return "at " + type + " belonging to a " + owner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, type);
    }
}
