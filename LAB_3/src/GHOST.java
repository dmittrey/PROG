public class GHOST {
    //поля экземпляра
    private String TypeSay;
    private String name;
    private String TypeLocation;
    //Конструктор

    public GHOST(String a, String c, String d) {
        name = a;
        TypeSay = c;
        TypeLocation = d;
    }

    //методы

    public String getTypeSay() {
        return TypeSay;
    }

    public String getLocation() {
        return TypeLocation;
    }

    public String getName() {
        return name;
    }

    public void setTypeSay(String Say) {
        this.TypeSay = Say;
    }

    public void setTypeLocation(String Location) {
        this.TypeLocation = Location;
    }
}
