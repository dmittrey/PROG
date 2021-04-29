package aliveInterface;

import java.util.Objects;

public class ChristopherRobin extends Person {

    private boolean readStatus;

    public ChristopherRobin(String name) {
        super(name, "human");
        readStatus = true;
    }


    public void stopReading() {
        readStatus = false;
    }

    public boolean isReading(){
        return readStatus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        if (!(otherObject instanceof ChristopherRobin)) return false;

        ChristopherRobin other = (ChristopherRobin) otherObject;

        return other.readStatus == readStatus;
    }

    @Override
    public String toString() {
        return super.toString()
                + "readStatus=" + readStatus
                + "]";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(readStatus);
    }

}
