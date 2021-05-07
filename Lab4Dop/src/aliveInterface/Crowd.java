package aliveInterface;

import Exceptions.NotPositiveAmountException;
import innerInterface.IntonationStatus;
import innerInterface.OpinionStatus;
import innerInterface.Phrase;
import innerInterface.Think;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Crowd implements Movable, Phrasable, Thinkable {

    private String shapeStatus;
    private Object currentPlace;
    private boolean existStatus;
    private final Person[] crowdMembers;


    public Crowd(Person[] aCrowdMembers) throws NotPositiveAmountException {
        if (Array.getLength(aCrowdMembers) <= 1)
            throw new NotPositiveAmountException("Enter the correct number of people in the crowd");
        currentPlace = "At the city";
        shapeStatus = "column";
        existStatus = true;
        crowdMembers = aCrowdMembers;
    }

    public static class Eeyore extends Person {

        public Eeyore(String name) {
            super(name, TypeOfAnimal.Donkey);
        }

        public void wagTail(String direction) {

            class Tail {
                private final String rotateDirection;

                public Tail(String aRotateDirection) {
                    rotateDirection = aRotateDirection;
                    boolean rotateStatus = true;
                }

                public String wigTail() {
                    if (rotateDirection.equals("Right")) return "Tail is spinning clockwise";
                    else return "Tail is spinning counterclockwise";
                }
            }

            Tail tail = new Tail(direction);

            tail.wigTail();
        }

        @Override
        public boolean equals(Object otherObject) {

            if (this == otherObject) return true;

            if (otherObject == null) return false;

            if (getClass() != otherObject.getClass()) return false;

            Eeyore other = (Eeyore) otherObject;

            return super.equals(other);
        }

        @Override
        public String toString() {
            return this.getName();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    public String getName() {
        StringBuilder names = new StringBuilder();
        for(int i=0; i<crowdMembers.length;i++){
            if (i!=crowdMembers.length-1) names.append(crowdMembers[i].getName()).append(", ");
            else names.append(crowdMembers[i].getName());
        }
        return names.toString();
    }

    public String getShapeStatus() {
        return shapeStatus;
    }

    public void setShapeStatus(String aShapeStatus) {
        shapeStatus = aShapeStatus;
    }

    public void disband() {
        existStatus = false;
    }

    @Override
    public Object getCurrentPlace() {
        return currentPlace;
    }

    @Override
    public void goTo(Object aPlace) {
        currentPlace = aPlace;
        for (Person i : crowdMembers) {
            i.goTo(aPlace);
        }
    }

    @Override
    public void toSay(Phrase aPhrase) {
        for (Person i : crowdMembers) {
            i.toSay(aPhrase);
        }
    }

    @Override
    public void toThink(Think aThink) {
        for (Person i : crowdMembers) {
            i.toThink(aThink);
        }
    }

    @Override
    public OpinionStatus getThinkFeeling() {
        return crowdMembers[0].getThinkFeeling();
    }

    @Override
    public String getThinkContent() {
        return crowdMembers[0].getThinkContent();
    }

    @Override
    public void setPhraseFeeling(IntonationStatus aFeeling) {
        for (Person i: crowdMembers) {
            i.setPhraseFeeling(aFeeling);
        }
    }

    @Override
    public String getPhraseContent() {
        return crowdMembers[0].getPhraseContent();
    }

    @Override
    public IntonationStatus getPhraseFeeling() {
        return crowdMembers[0].getPhraseFeeling();
    }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Crowd other = (Crowd) otherObject;

        if ((!existStatus) || (!other.existStatus)) return false;

        return currentPlace.equals(other.currentPlace)
                && shapeStatus.equals(other.shapeStatus)
                && Arrays.equals(crowdMembers, other.crowdMembers);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlace, shapeStatus, crowdMembers);
    }
}
