package aliveInterface;

import Exceptions.NotPositiveAmountException;
import innerInterface.IntonationStatus;
import innerInterface.OpinionStatus;
import innerInterface.Phrase;
import innerInterface.Think;

import java.util.Objects;

public class Crowd implements Movable, Phrasable, Thinkable{

    private Object currentPlace;
    private String shapeStatus;
    private Think think = new Think("", null);
    private Phrase phrase = new Phrase("", null);
    private boolean existStatus;
    private String name = "crowd";


    public Crowd(int crowdAmount, Person[] crowdMembers) throws NotPositiveAmountException {
        if (crowdAmount <= 1) throw new NotPositiveAmountException("Enter the correct number of people in the crowd");
        currentPlace = "at the city";
        shapeStatus = "column";
        existStatus = true;
    }

    public static class Eeyore extends Person {

        public Eeyore(String name) {
            super(name, "Donkey");
        }

        public String wagTail(String direction) {

            class Tail {
                private String rotateDirection;
                private boolean rotateStatus;

                public Tail(String aRotateDirection) {
                    rotateDirection = aRotateDirection;
                    rotateStatus = true;
                }

                public String wigTail() {
                    if (rotateDirection.equals("Right")) return "Tail is spinning clockwise";
                    else return "Tail is spinning counterclockwise";
                }
            }

            Tail tail = new Tail(direction);

            return tail.wigTail();
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

    public String getName(){
        return name;
    }

    public String getShapeStatus() {
        return shapeStatus;
    }

    public void setShapeStatus(String aShapeStatus) {
        shapeStatus = aShapeStatus;
    }

    public void disband(){
        existStatus = false;
    }

    @Override
    public Object getCurrentPlace() {
        return currentPlace;
    }

    @Override
    public void goTo(Object aPlace) {
        currentPlace = aPlace;
    }

    @Override
    public void toSay(Phrase aPhrase) {
        phrase.setContent(aPhrase.getContent());
        phrase.setInner(aPhrase.getInner());
    }

    @Override
    public void toThink(Think aThink) {
        think.setContent(aThink.getContent());
        think.setInner(aThink.getInner());
    }

    @Override
    public OpinionStatus getThinkFeeling(){
        return think.getInner();
    }

    @Override
    public String getThinkContent(){
        return think.getContent();
    }

    @Override
    public void setPhraseFeeling(IntonationStatus aFeeling) {
        phrase.setInner(aFeeling);
    }

    @Override
    public String getPhraseContent(){
        return phrase.getContent();
    }

    @Override
    public IntonationStatus getPhraseFeeling() {
        return phrase.getInner();
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
                && think.equals(other.think)
                && phrase.equals(other.phrase)
                && name.equals(other.name);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlace, shapeStatus, think, phrase, name);
    }
}
