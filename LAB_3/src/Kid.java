public class Kid extends HUMAN {

    private boolean SoskaStatus;

    public Kid(String name, String act, boolean a) {
        this.setName(name);
        this.setTypeAction(act);
        this.SetScareStatus(a);
    }

    public boolean GetSoskaStatus() {
        return SoskaStatus;
    }

    public void SetSoskaStatus(boolean soskaStatus) {
        SoskaStatus = soskaStatus;
    }


}
