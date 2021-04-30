package aliveInterface;

/**
 * Класс толпы
 *
 *
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
 * <p>
 * можно попробовать наложить на все методы этого класса ошибку которуб тригерит поле толпаВместе,
 * и проверяя эту хуету мы будем блочить все поля
 */


import Exceptions.NotPositiveAmountException;
import innerInterface.Phrase;
import innerInterface.Think;

import java.util.Objects;

public class AllAllAll implements Alive {

    private Object currentPlace;
    private String shapeStatus;
    private Think think = new Think("", "");
    private Phrase phrase = new Phrase("", "");
    private String name;
    private boolean existStatus;


    public AllAllAll(int crowdAmount, String aName) throws NotPositiveAmountException {
        if (crowdAmount <= 1) throw new NotPositiveAmountException("Enter the correct number of people in the crowd");
        currentPlace = "at the city";
        shapeStatus = "column";
        name = aName;
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
    }

    public String getName(){
        return name;
    }

    //надо как-то норм оформить вывод структуры толпы
    public String getShapeStatus() {
        return shapeStatus;
    }

    public void setShapeStatus(String aShapeStatus) {
        shapeStatus = aShapeStatus;
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
        phrase.setFeeling(aPhrase.getFeeling());
    }

    @Override
    public void toThink(Think aThink) {
        think.setContent(aThink.getContent());
        think.setFeeling(aThink.getFeeling());
    }

    public void disband(){
        existStatus = false;
    }

    @Override
    public String getThinkFeeling(){
        return think.getFeeling();
    }

    @Override
    public String getThinkContent(){
        return think.getContent();
    }

    @Override
    public void setPhraseFeeling(String aFeeling) {
        phrase.setFeeling(aFeeling);
    }

    @Override
    public String getPhraseContent(){
        return phrase.getContent();
    }

    @Override
    public String getPhraseFeeling() {
        return phrase.getFeeling();
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
