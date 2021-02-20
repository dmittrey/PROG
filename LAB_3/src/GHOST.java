public class GHOST {
    //поля экземпляра
    private String TargetMove;
    private String TypeSay;
    private String name;
    private String TypeLocation;
    //Конструктор

    public GHOST(String a, String b, String c, String d){
        name = a;
        TargetMove = b;
        TypeSay = c;
        TypeLocation = d;
    }

    //методы

    public String getTargetMove(){
       //зависит от программы
    }

    public String getTypeSay() {
        //Зависит от программы
    }

    public String getLocation(){
        //Зависит от программы
    }

    public String getName(){
        //Зависит от программы
    }

    public void setTargetMove(String Target){
        this.TargetMove = Target;
    }

    public  void setTypeSay(String Say){
        this.TypeSay = Say;
    }

    public  void setName(String Name){
        this.name = Name;
    }

    public void setTypeLocation(String Location){
        this.TypeLocation = Location;
    }
}
