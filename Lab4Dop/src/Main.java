import aliveInterface.AllAllAll;
import aliveInterface.ChristopherRobin;
import aliveInterface.Person;
import innerInterface.Phrase;
import innerInterface.Think;

public class Main {

    public static void main(String[] args) {

        AllAllAll crowd = new AllAllAll(5, "All-All-All"); //Инициализируем переменную толпы

        ChristopherRobin christopherRobin = new ChristopherRobin("Christopher Robin");
        //Инициализировали Кристофера

        Place christopherRobinHome = new Place(christopherRobin, "House");
        //Инициализируем дом Кристофера

        System.out.println(crowd.getName() + " now " + crowd.getCurrentPlace());

        crowd.goTo(christopherRobinHome);
        System.out.println(crowd.getName() + " now " + crowd.getCurrentPlace().toString());

        if (crowd.getCurrentPlace().equals(christopherRobinHome)) crowd.toThink(new Think("We came to say goodbye", "They really, really didn't want to think about it" ));

        crowd.toSay(new Phrase("Hello", "They were calm"));

        if (crowd.getThinkFeeling().equals("They came to say goodbye")) crowd.setPhraseFeeling(
                "Everyone felt somehow sad and uneasy");

        if (crowd.getPhraseContent().equals("Everyone felt somehow sad and uneasy")){crowd.setShapeStatus("Heap");

            crowd.toThink(new Think(
                    "We have to push each other", "They were waiting for someone else to speak"));

            crowd.toSay(new Phrase("Come on, you", "They wanted to displace a weak person"));

            AllAllAll.Eeyore Ia = new AllAllAll.Eeyore("Eeyore");


            if (Ia.isExist()) {
                Place iaBack = new Place(Ia, "Near back");

                crowd.goTo(iaBack);

                Ia.toThink(new Think("I need to wag my tail", "It will motivate him"));
            }

            if (Ia.getThinkContent().equals("I need to wag my tail")){
                Ia.wagTail("Clockwise");

                Ia.toSay(new Phrase("Goodbye" + christopherRobin.getName(),
                    "He was sorry"));
            }

            if (Ia.getPhraseContent().equals("Goodbye" + christopherRobin.getName())) {
            crowd.disband();
            }
        }

        Person vinnie = new Person("Vinnie the Pooh", "bear"){};

        christopherRobin.stopReading();

        if (!christopherRobin.isReading()){

            christopherRobin.toThink(new Think("He wants to thank",
                "He liked that no one interrupted him"));

            christopherRobin.setEyesTarget("In front of him");

            if (christopherRobin.getEyesTarget().equals("In front of him") && vinnie.isExist())
                christopherRobin.setEyesTarget(vinnie);

            if (christopherRobin.getEyesTarget().equals(vinnie)) {
                christopherRobin.goTo("There");
                vinnie.goTo("There");
            }

            Place roadPart = new Place(null, "most of way");

            if (roadPart.getType().equals("most of way")) christopherRobin.toSay(
                    new Phrase(":", "calm"));
        }
    }
}
