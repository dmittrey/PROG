package aliveInterface;

public class CrowdMember extends Person {

    public CrowdMember(String aName, Object aGenus) {
        super(aName, aGenus);
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

        @Override
        public boolean equals(Object otherObject) {

            if (this == otherObject) return true;

            if (otherObject == null) return false;

            if (getClass() != otherObject.getClass()) return false;

            Crowd.Eeyore other = (Crowd.Eeyore) otherObject;

            return super.equals(other);
        }

        @Override
        public String toString() {
            return this.getName();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
}


