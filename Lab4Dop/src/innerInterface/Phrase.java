package innerInterface;

import aliveInterface.ChristopherRobin;

import java.util.Objects;

/**
 * Реализуем класс для фраз которые произносят
 * Имплементируем интерфейс Inner
 * <p>
 * Реализованы поля:
 * <p>
 * text --- Содержимое
 * intonation --- Эмоциональный окрас
 * <p>
 * Реализованы методы:
 * <p>
 * String getContent() --- Вывести содержимое фразы
 * <p>
 * String getFeeling() --- Вывести эмоциональный окрас фразы
 */

public class Phrase implements Inner {
    private String text;
    private String intonation;

    public Phrase(String aText, String aIntonation) {
        text = aText;
        intonation = aIntonation;
    }

    @Override
    public String getContent() {
        return text;
    }

    @Override
    public String getFeeling() {
        return intonation;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        if (!(otherObject instanceof Phrase)) return false;

        Phrase other = (Phrase) otherObject;

        return other.text == text
                && other.intonation == intonation;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[text=" + text
                + "intonation=" + intonation
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, intonation);
    }
}
