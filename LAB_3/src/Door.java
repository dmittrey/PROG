public class Door implements NotAlive {
    private boolean OpenStatus;
    private String Membership;

    public Door(boolean status, String member) {
        OpenStatus = status;
        Membership = member;
    }

    public void Open() {
        this.OpenStatus = true;
    }

    public void Close() {
        this.OpenStatus = false;
    }

    public String getMembership() {
        return this.Membership;
    }

    public boolean GetStatus() {
        return OpenStatus;
    }
}
//тут вроде закончил