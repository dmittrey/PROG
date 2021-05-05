package innerInterface;

import java.util.Objects;

public class Phrase implements Inner {
    private String text;
    private IntonationStatus intonation;

    public Phrase(String aText, IntonationStatus aIntonation) {
        text = aText;
        intonation = aIntonation;
    }

    @Override
    public String getContent() {
        return text;
    }

    @Override
    public IntonationStatus getInner() {
        return intonation;
    }

    @Override
    public void setInner(Object aFeeling) {
        intonation = (IntonationStatus) aFeeling;
    }

    @Override
    public void setContent(String aContent) {
        text = aContent;
    }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Phrase other = (Phrase) otherObject;

        return text.equals(other.text)
                && intonation.equals(other.intonation);
    }

    @Override
    public String toString() {
        return text + " with feeling that "
                + intonation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, intonation);
    }
}
