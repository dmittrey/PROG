package innerInterface;

import java.util.Objects;

public class Think implements Inner {
    private String idea;
    private OpinionStatus opinion;

    public Think(String aIdea, OpinionStatus aOpinion) {
        idea = aIdea;
        opinion = aOpinion;
    }

    @Override
    public String getContent() {
        return idea;
    }

    @Override
    public OpinionStatus getInner() {
        return opinion;
    }

    @Override
    public void setInner(Object aFeeling) {
        opinion = (OpinionStatus) aFeeling;
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
        return opinion + idea;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idea, opinion);
    }
}
