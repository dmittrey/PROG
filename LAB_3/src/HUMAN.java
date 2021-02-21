public abstract class HUMAN implements Alive {
    private String Name;
    private String TypeAction;
    private String Location;
    private boolean ScareStatus;
    private boolean MoveAroundStatus;

    public String getName() {
        return this.Name;
    }

    public String getTypeAction() {
        return this.TypeAction;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void SetScareStatus(boolean b) {
        ScareStatus = b;
    }

    public void setTypeAction(String typeAction) {
        this.TypeAction = typeAction;
    }

    public void MoveAround() {
        MoveAroundStatus = true;
    }

    public boolean getMoveAroundStatus() {
        return MoveAroundStatus;
    }

    public boolean ScareStatus() {
        return ScareStatus;
    }

    @Override
    public void Move(String location) {
        this.Location = location;
    }

    @Override
    public void GetScared() {
        this.ScareStatus = true;
    }

    @Override
    //добавить в конструктор поле выше
    public void Open(NotAlive x) {
        x.Open();
    }

    @Override
    public void Close(NotAlive x) {
        x.Close();
    }
}
