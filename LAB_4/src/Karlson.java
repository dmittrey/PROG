public class Karlson extends Human{
    private Nastr moodStatus;
    private boolean coverSheetStatus;
    private BoxInventory objInHands;
    private String favouriteHand;

    public void setMoodStatus(Nastr n){
        moodStatus = n;
    }

    public String getMoodStatus(){
        if (this.moodStatus.equals(Nastr.happy)) {
            return this.getName()+" радуется!";
        }
        else if (this.moodStatus.equals(Nastr.sad)) {
            return this.getName()+" расстроен!";
        }
        else if (this.moodStatus.equals(Nastr.laugh)) {
            return this.getName()+" смеется!";
        }
        else {
            return this.getName()+" спокоен!";
        }
    }

    public String getHearDoorStatus() {
        return this.getName()+" услышал как дверь закрылась!";
    }

    private String getFavouriteHand(){
        return this.favouriteHand;
    }

    public void pinch(Gunilla gunilla){
        gunilla.getPinched(this.getName());
    }

    public String makeNoise() {
        return this.getName()+" издал звук!";
    }

    public void propHead(){
        class Hand {
            final String handOwner = Karlson.this.getName();
            final boolean nearHeadStatus = true;
            final String typeHand = Karlson.this.getFavouriteHand();

            public String status(){
                if (typeHand.equals("Right")) {return this.handOwner+" подпирается правой рукой";}
                else {return this.handOwner+" подпирается левой рукой";}
            }
        }

    }

    public void shakeLeg(){
        class Hand {
            final String handOwner = Karlson.this.getName();
            final boolean nearHeadStatus = true;
            final String typeHand = Karlson.this.getFavouriteHand();

            public String status(){
                if (typeHand.equals("Right")) {return this.handOwner+" подпирается правой рукой";}
                else {return this.handOwner+" подпирается левой рукой";}
            }
        }

    }

    @Override
    public void hearNoise() {

    }

    @Override
    public void turnView() {

    }
}
