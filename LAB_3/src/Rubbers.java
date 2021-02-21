import java.util.Arrays;



    public class Rubbers extends HUMAN {
    public Rubbers(String name, String act, boolean scare){
        this.setName(name);
        this.setTypeAction(act);
        this.SetScareStatus(scare);
    }

    //private string

    public String Whistle(){
        return this.getName()+" Свистнул!";
    }
    public String Xruk(){
        return this.getName()+" хрюкнул от ужаса!";
    }
    public String Throw(){
        return this.getName()+" уронил на пол:"+ Arrays.toString(ContentOfBox.values())+" и все остальное!";
    }
}
