package aliveInterface;

/**
 * Реализуются поля:
 * <p>
 * currentPlace --- Текущая локация
 * shapeStatus --- Структура толпы
 * <p>
 * Реализуются методы:
 * <p>
 * public String getShapeStatus() --- Выводит структуру толпы
 * <p>
 * public void setShapeStatus(String aShapeStatus) --- Меняет структуру толпы
 * <p>
 * public String getCurrentPlace() --- Выводит локацию толпы
 * <p>
 * public void goTo(String aPlace) --- Меняет локацию толпы
 * <p>
 * public String toSay(Phrase aPhrase) --- Выводит фразу и чувства
 * <p>
 * public String toThink(Think aThink) --- Выводит мысль и опасения
 * <p>
 * Также реализуется статический вложенный класс Eeyore и метод wigTail с локальным классом tail
 */


import innerInterface.Phrase;
import innerInterface.Think;

import java.util.Objects;

public class AllAllAll implements Alive {

    private String currentPlace;
    private String shapeStatus;


    public AllAllAll(String aCurrentPlace, boolean aGoodByeStatus) {
        currentPlace = aCurrentPlace;
        shapeStatus = "column";
    }

    public static class Eeyore extends Person {

        public Eeyore(String name) {
            super(name, "Donkey");
        }

        public String wagTail(String direction) {

            class Tail {
                private String rotateDirection;

                public Tail(String aRotateDirection) {
                    rotateDirection = aRotateDirection;
                }

                public String wigTail() {
                    if (rotateDirection.equals("Right")) return "Tail is spinning clockwise";
                    else return "Tail is spinning counterclockwise";
                }
            }

            Tail tail = new Tail(direction);

            return tail.wigTail();

        }
    }

    //надо как-то норм оформить вывод структуры толпы
    public String getShapeStatus() {
        return shapeStatus;
    }

    public void setShapeStatus(String aShapeStatus) {
        shapeStatus = aShapeStatus;
    }

    @Override
    public String getCurrentPlace() {
        return "They came to " + currentPlace;
    }

    @Override
    public void goTo(String aPlace) {
        currentPlace = aPlace;
    }

    @Override
    public String toSay(Phrase aPhrase) {
        return "They all said '" + aPhrase.getContent() + "' with feeling " + aPhrase.getFeeling();
    }

    @Override
    public String toThink(Think aThink) {
        return "They all thought '" + aThink.getContent() + "' with feeling " + aThink.getFeeling();
    }

    //переопределяем hashcode, toString, hashcode

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        if (!(otherObject instanceof AllAllAll)) return false;

        AllAllAll other = (AllAllAll) otherObject;

        return currentPlace.equals(other.currentPlace) &&
                shapeStatus.equals(other.shapeStatus);
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[currentPlace=" + currentPlace
                + "shapeStatus=" + shapeStatus
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPlace, shapeStatus);
    }
}
