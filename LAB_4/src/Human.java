public abstract class Human implements Alive{
    private String name; //Name
    private Places location; //Location in home
    private String homeLocation;//where's your home in Stokholm
    private String gender;//"M" or "W"


    public void setHearRing(){
        //if you heard door's ring
        boolean hearRing = true;
    }

    public String getName() {
        return name;
    }

    public String getGender() { return gender; }

    public String say(String s){
        if (gender.equals("M")) {
            return this.name+" сказал: "+s;
        }
        else {
            return this.name+" сказала: "+s;
        }
    }

    public void move(Places l) {
        this.location = l;
    }

    public Places getlocation(){
        return this.location;
    }

    public String think(String s){
        if (gender.equals("M")) {
            return this.name+" подумал: "+s;
        }
        else {
            return this.name+" подумала: "+s;
        }
    }


}
