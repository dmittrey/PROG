import aliveInterface.AllAllAll;
import aliveInterface.ChristopherRobin;
import aliveInterface.Person;
import innerInterface.Phrase;
import innerInterface.Think;

public class Main {

    public static void main(String[] args) {

        AllAllAll crowd = new AllAllAll(5);// Инициализировали толпу

        ChristopherRobin christopherRobin = new ChristopherRobin("Кристофер Робин");//Сделали кростофера

        Object ChristoferRobinHome = new Object(){
            private Person owner = christopherRobin;

            public void changeOwner(Person aOwner){
                owner = aOwner;
            }
        }; //создали дом

        crowd.goTo(ChristoferRobinHome);//пиздуем к дому кристофера

        Think sadThink = new Think("They come to say goodbye", "they didn't want to think about it");

        if sadThink.getFeeling().equals("they didn't want to think about it")

        crowd.toSay()



        crowd.toSay(new Phrase("Hello!", "sad"));

        crowd.toThink(new Think("Come to say goodbye", "They didn't want to think about it"));

        if crowd.





        crowd.goTo("Cristopher Rhobins home");
    }
}
