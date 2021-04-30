package aliveInterface;

import Exceptions.NotAliveException;
import innerInterface.Phrase;
import innerInterface.Think;

import java.util.Objects;

/**
 * Класс персоны
 *
 *
 *
 * Реализованы поля:
 * name --- имя
 * genus --- род
 * eyes.color --- цвет глаз
 * eyes.target --- куда направлены глаза
 * <p>
 * Реализованы методы:
 * String getEyesTarget() --- Вывести куда челик смотрит
 * <p>
 * EyeColor getEyesColor() --- Вывести цвет глаз челика
 * <p>
 * String getName() --- Вывести имя челика
 * <p>
 * String getGenus() --- Вывести род челика
 * <p>
 * void setEyesTarget(String aTarget) --- Перевести взгляд челика
 * <p>
 * Реализован нестатический вложенный класс Eyes который использует enum EyeColor
 * <p>
 * <p>
 * <p>
 * Осталось переопределить equals, toString, hashCode и реализовать обработку исключений
 */

public abstract class Person implements Alive {

    private Object currentPlace = "";
    //абстрактный класс
    private String name;

    private String genus;

    private Eyes eyes;

    private Think think = new Think("", "");

    private Phrase phrase = new Phrase("","");

    private boolean aliveStatus;

    public Person(String aName, String aGenus, EyeColor aColor, String aTarget) {
        name = aName;
        genus = aGenus;
        eyes = new Eyes(aColor, aTarget);
    }

    public Person(String aName, String aGenus, String aTarget) {
        name = aName;
        genus = aGenus;
        eyes = new Eyes(EyeColor.brown, aTarget);
    }

    public Person(String aName, String aGenus, EyeColor aColor) {
        name = aName;
        genus = aGenus;
        eyes = new Eyes(aColor, "");
    }

    public Person(String aName, String aGenus) {
        aliveStatus = true;
        name = aName;
        genus = aGenus;
        eyes = new Eyes(EyeColor.brown, "");
    }

    private class Eyes {
        private EyeColor color;

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

    public void murder(){
        aliveStatus = false;
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

        if (getClass() != otherObject.getClass()) return false;

        if (!(otherObject instanceof Person)) return false;

        Person other = (Person) otherObject;

        return other.currentPlace.equals(currentPlace)
                && other.name.equals(name)
                && other.genus.equals(genus)
                && other.eyes.equals(eyes);
    }

    @Override
    public String toString() {
        return name + " from " + genus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlace, name, genus, eyes);
    }
}
