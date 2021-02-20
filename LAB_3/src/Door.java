public class Door {
    boolean OpenStatus;
    String Membership;

    public Door(boolean status, String member){
        OpenStatus = status;
        Membership = member;
    }

    public void Open(){
        this.OpenStatus = true;
    }

    public void Close(){
        this.OpenStatus = false;
    }

    public String getMembership(){
        return this.Membership;
    }
}
//тут вроде закончил