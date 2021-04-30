package aliveInterface;

import Exceptions.NotAliveException;
import innerInterface.Phrase;
import innerInterface.Think;
import java.util.Objects;

public abstract class Person implements Alive {

    private Object currentPlace = "";
    //абстрактный класс
    private final String name;

    private final String genus;

    private Eyes eyes;

    private Think think = new Think("", "");

    private Phrase phrase = new Phrase("","");

    private boolean aliveStatus;

    public Person(String aName, String aGenus) {
        aliveStatus = true;
        name = aName;
        genus = aGenus;
        eyes = new Eyes(EyeColor.brown, "");
    }

    private class Eyes {
        private final EyeColor color;

        private Object target;

        private Eyes(EyeColor aColor, Object aTarget) {
            color = aColor;
            target = aTarget;
        }

        private void changeTarget(Object aTarget) {
            target = aTarget;
        }

        private Object getTarget() {
            return target;
        }

        private EyeColor getColor() {
            return color;
        }
    }

    public Object getEyesTarget() {
        if (!aliveStatus) throw new NotAliveException();
        return eyes.getTarget();
    }

    public String getName() {
        if (!aliveStatus) throw new NotAliveException();
        return name;
    }

    public void setEyesTarget(Object aTarget) {
        if (!aliveStatus) throw new NotAliveException();
        eyes.changeTarget(aTarget);
    }


    @Override
    public void goTo(Object aPlace) {
        if (!aliveStatus) throw new NotAliveException();
        currentPlace = aPlace;
    }

    @Override
    public Object getCurrentPlace() {
        if (!aliveStatus) throw new NotAliveException();
        return name + " near " + currentPlace + " right now";
    }

    @Override
    public String getThinkFeeling(){
        if (!aliveStatus) throw new NotAliveException();
        return think.getFeeling();
    }

    @Override
    public String getThinkContent(){
        if (!aliveStatus) throw new NotAliveException();
        return think.getContent();
    }

    @Override
    public void setPhraseFeeling(String aContent){
        if (!aliveStatus) throw new NotAliveException();
        phrase.setFeeling(aContent);
    }

    @Override
    public String getPhraseContent(){
        if (!aliveStatus) throw new NotAliveException();
        return phrase.getContent();
    }

    @Override
    public String getPhraseFeeling(){
        if (!aliveStatus) throw new NotAliveException();
        return phrase.getFeeling();
    }

    public boolean isExist(){
        return aliveStatus;
    }

    @Override
    public void toSay(Phrase aPhrase) {
        if (!aliveStatus) throw new NotAliveException();
        phrase.setContent(aPhrase.getContent());
        phrase.setFeeling(aPhrase.getFeeling());
    }

    @Override
    public void toThink(Think aThink) {
        if (!aliveStatus) throw new NotAliveException();
        think.setContent(aThink.getContent());
        think.setFeeling(aThink.getFeeling());
    }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!(otherObject instanceof Person)) return false;

        Person other = (Person) otherObject;

        if ((!aliveStatus) || (!other.aliveStatus)) return false;

        return currentPlace.equals(other.currentPlace)
                && name.equals(other.name)
                && genus.equals(other.genus)
                && eyes.equals(other.eyes)
                && think.equals(other.think)
                && phrase.equals(other.phrase);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlace, name, genus, eyes, think, phrase);
    }
}
