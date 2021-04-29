package aliveInterface;

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
        name = aName;
        genus = aGenus;
        eyes = new Eyes(EyeColor.brown, "");
    }

    private class Eyes {
        private EyeColor color;

        private String target;

        private Eyes(EyeColor aColor, String aTarget) {
            color = aColor;
            target = aTarget;
        }

        private void changeTarget(String aTarget) {
            target = aTarget;
        }

        private String getTarget() {
            return target;
        }

        private EyeColor getColor() {
            return color;
        }
    }

    public String getEyesTarget() {
        return eyes.getTarget();
    }

    public EyeColor getEyesColor() {
        return eyes.getColor();
    }

    public String getName() {
        return name;
    }

    public String getGenus() {
        return genus;
    }

    public void setEyesTarget(String aTarget) {

// тут надо продумать момент, скорее всего пропишу просто исключение или првоерку на пустое значение
        System.out.println("Меняем направление взгляда у " + this.name);
        if (aTarget.equals(""))
        eyes.changeTarget(aTarget);
    }


    @Override
    public void goTo(Object aPlace) {
        currentPlace = aPlace;
    }

    @Override
    public String toSay(Phrase aPhrase) {
        return name + " says '" + aPhrase.getContent() + "' with feeling " + aPhrase.getFeeling();
    }

    @Override
    public String toThink(Think aThink) {
        return name + " thought '" + aThink.getContent() + "' with feeling " + aThink.getFeeling();
    }

    @Override
    public String getCurrentPlace() {
        return name + " near " + currentPlace + " right now";
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
        return getClass().getName()
                + "[currentPlace=" + currentPlace
                + "name=" + name
                + "genus=" + genus
                + "eyes=" + eyes
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlace, name, genus, eyes);
    }
}
