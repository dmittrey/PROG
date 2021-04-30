package innerInterface;

import java.util.Objects;

public class Think implements Inner {
    private String idea;
    private String opinion;

    public Think(String aIdea, String aOpinion) {
        idea = aIdea;
        opinion = aOpinion;
    }

    @Override
    public String getContent() {
        return idea;
    }

    @Override
    public String getFeeling() {
        return opinion;
    }

    @Override
    public void setFeeling(String aFeeling) {
        opinion = aFeeling;
    }

    @Override
    public void setContent(String aContent) {
        idea = aContent;
    }

    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Think other = (Think) otherObject;

        return idea.equals(other.idea)
                && opinion.equals(other.opinion);
    }

    @Override
    public String toString() {
        return idea + " with feeling that "
                + opinion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idea, opinion);
    }
}
