import Exceptions.NotPositiveAmountException;
import aliveInterface.AllAllAll;
import aliveInterface.ChristopherRobin;
import aliveInterface.Person;
import innerInterface.IntonationStatus;
import innerInterface.OpinionStatus;
import innerInterface.Phrase;
import innerInterface.Think;

public class Main {

    public static void main(String[] args) throws NotPositiveAmountException {

        AllAllAll crowd = new AllAllAll(5, "All-All-All");

        ChristopherRobin christopherRobin = new ChristopherRobin("Christopher Robin");

        Place christopherRobinHome = new Place(christopherRobin, "House");

        System.out.println(crowd.getName() + " now " + crowd.getCurrentPlace());

        crowd.goTo(christopherRobinHome);
        System.out.println(crowd.getName() + " now " + crowd.getCurrentPlace().toString());

        if (crowd.getCurrentPlace().equals(christopherRobinHome)) crowd.toThink(new Think(
                "We came to say goodbye", OpinionStatus.Sad));
        System.out.println(crowd.getName() + " are thinking!! '" + crowd.getThinkContent() + "' !!with feeling that "
                + crowd.getThinkFeeling().toString());


        crowd.toSay(new Phrase("Hello", IntonationStatus.calm));
        System.out.println(crowd.getName() + " said '" + crowd.getPhraseContent() + "' with feeling that "
                + crowd.getPhraseFeeling().toString());


        if (crowd.getThinkContent().equals("We came to say goodbye")) crowd.setPhraseFeeling(IntonationStatus.sad);
        System.out.println("Now " + crowd.getName() + " are feeling " + crowd.getPhraseFeeling().toString());


        if (crowd.getPhraseFeeling().equals(IntonationStatus.sad)){

            crowd.setShapeStatus("Heap");
            System.out.println("Now " + crowd.getName() + " is " + crowd.getShapeStatus());

            crowd.toThink(new Think(
                    "We have to push each other", OpinionStatus.Boring));
            System.out.println(crowd.getName() + " are thinking '" + crowd.getThinkContent() + "' with feeling that "
                    + crowd.getThinkFeeling().toString());

            crowd.toSay(new Phrase("Come on, you", IntonationStatus.panic));
            System.out.println(crowd.getName() + " said '" + crowd.getPhraseContent() + "' with feeling that "
                    + crowd.getPhraseFeeling().toString());

            AllAllAll.Eeyore Ia = new AllAllAll.Eeyore("Eeyore");
            System.out.println(Ia.getName() + " is now exist");


            if (Ia.isExist()) {
                Place iaBack = new Place(Ia, "Near back");

                crowd.goTo(iaBack);
                System.out.println("Now " + crowd.getName() + " at " + crowd.getCurrentPlace());

                Ia.toThink(new Think("I need to wag my tail", OpinionStatus.Motivation));
                System.out.println(Ia.getName() + " is thinking '" + Ia.getThinkContent() + "' with feeling that "
                        + Ia.getThinkFeeling().toString());
            }

            if (Ia.getThinkContent().equals("I need to wag my tail")){
                Ia.wagTail("Clockwise");
                System.out.println(Ia.getName() + "'s tail is wagging");

                Ia.toSay(new Phrase("Goodbye " + christopherRobin.getName(), IntonationStatus.sorry));
                System.out.println(Ia.getName() + " said '" + Ia.getPhraseContent() + "' with feeling that "
                        + Ia.getPhraseFeeling().toString());
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

            christopherRobin.toThink(new Think("He wants to thank", OpinionStatus.Funny));
            System.out.println(christopherRobin.getName() + " are thinking '" + christopherRobin.getThinkContent() + "' with feeling that "
                    + christopherRobin.getThinkFeeling().toString());

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
                    new Phrase(":", IntonationStatus.calm));
            System.out.println(christopherRobin.getName() + " said '" + christopherRobin.getPhraseContent() + "' with feeling that "
                    + christopherRobin.getPhraseFeeling().toString());
        }
    }
}