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

        if (crowd.getCurrentPlace().equals(christopherRobinHome)) crowd.toThink(new Think(
                "We came to say goodbye", "They really, really didn't want to think about it" ));
        System.out.println(crowd.getName() + " are thinking '" + crowd.getThinkContent() + "' with feeling that "
                + crowd.getThinkFeeling());


        crowd.toSay(new Phrase("Hello", "They were calm"));
        System.out.println(crowd.getName() + " said '" + crowd.getPhraseContent() + "' with feeling that "
                + crowd.getPhraseFeeling());


        if (crowd.getThinkContent().equals("We came to say goodbye")) crowd.setPhraseFeeling(
                "somehow sad and uneasy");
        System.out.println("Now " + crowd.getName() + " are feeling " + crowd.getPhraseFeeling());


        if (crowd.getPhraseFeeling().equals("somehow sad and uneasy")){

            crowd.setShapeStatus("Heap");
            System.out.println("Now " + crowd.getName() + " is " + crowd.getShapeStatus());

            crowd.toThink(new Think(
                    "We have to push each other", "They were waiting for someone else to speak"));
            System.out.println(crowd.getName() + " are thinking '" + crowd.getThinkContent() + "' with feeling that "
                    + crowd.getThinkFeeling());

            crowd.toSay(new Phrase("Come on, you", "They wanted to displace a weak person"));
            System.out.println(crowd.getName() + " said '" + crowd.getPhraseContent() + "' with feeling that "
                    + crowd.getPhraseFeeling());

            AllAllAll.Eeyore Ia = new AllAllAll.Eeyore("Eeyore");
            System.out.println(Ia.getName() + " is now exist");


            if (Ia.isExist()) {
                Place iaBack = new Place(Ia, "Near back");

                crowd.goTo(iaBack);
                System.out.println("Now " + crowd.getName() + " at " + crowd.getCurrentPlace());

                Ia.toThink(new Think("I need to wag my tail", "It will motivate him"));
                System.out.println(Ia.getName() + " is thinking '" + Ia.getThinkContent() + "' with feeling that "
                        + Ia.getThinkFeeling());
            }

            if (Ia.getThinkContent().equals("I need to wag my tail")){
                Ia.wagTail("Clockwise");
                System.out.println(Ia.getName() + "'s tail is wagging");

                Ia.toSay(new Phrase("Goodbye " + christopherRobin.getName(),
                    "He was sorry"));
                System.out.println(Ia.getName() + " said '" + Ia.getPhraseContent() + "' with feeling that "
                        + Ia.getPhraseFeeling());
            }

            if (Ia.getPhraseContent().equals("Goodbye " + christopherRobin.getName())) {
            crowd.disband();
            System.out.println("The " + crowd.getName() + " dispersed");
            }

        }

        Person vinnie = new Person("Vinnie the Pooh", "bear"){};

        christopherRobin.stopReading();
        System.out.println("Now " + christopherRobin.getName() + "is not reading");

        if (!christopherRobin.isReading()){

            christopherRobin.toThink(new Think("He wants to thank",
                "He liked that no one interrupted him"));
            System.out.println(christopherRobin.getName() + " are thinking '" + christopherRobin.getThinkContent() + "' with feeling that "
                    + christopherRobin.getThinkFeeling());

            christopherRobin.setEyesTarget("In front of him");
            System.out.println(christopherRobin.getName() + "target his eyes to " + christopherRobin.getEyesTarget());

            if (christopherRobin.getEyesTarget().equals("In front of him") && vinnie.isExist())
                christopherRobin.setEyesTarget(vinnie);
            System.out.println(christopherRobin.getName() + "target his eyes to " + christopherRobin.getEyesTarget());

            if (christopherRobin.getEyesTarget().equals(vinnie)) {
                christopherRobin.goTo("There");
                System.out.println(crowd.getName() + " now " + crowd.getCurrentPlace());

                vinnie.goTo("There");
                System.out.println(vinnie.getName() + " now " + vinnie.getCurrentPlace());
            }

            Place roadPart = new Place(null, "most of way");

            if (roadPart.getType().equals("most of way")) christopherRobin.toSay(
                    new Phrase(":", "calm"));
            System.out.println(christopherRobin.getName() + " said '" + christopherRobin.getPhraseContent() + "' with feeling that "
                    + christopherRobin.getPhraseFeeling());
        }
    }
}
