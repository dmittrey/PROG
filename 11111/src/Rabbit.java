public class Rabbit{

    private boolean isAlive;
    private boolean isEatingCarrot;

    public Rabbit(boolean aIsEatingCarrot){
        isAlive = true;
        isEatingCarrot = aIsEatingCarrot;
    }

    public Rabbit(){
        isAlive = true;
        isEatingCarrot = false;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public boolean isEatingCarrot() throws DieException {
        if (isAlive == false) throw new DieException();
        else return isEatingCarrot;
    }

    public void setEatingCarrot() throws DieException {
        if (isAlive == false) throw new DieException();
        else isEatingCarrot = true;
    }

    public void kill() throws DieException {
        if (isAlive == false) throw new DieException();
        else isAlive = false;
    }
}
