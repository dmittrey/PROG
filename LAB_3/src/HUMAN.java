public abstract class HUMAN {
    private String Name;
    private String TypeAction;

    public String getName(){
        return this.Name;
    }

    public String getTypeAction(){
        return this.TypeAction;
    }

    public String getProf(){
        return this.Prof;
    }

    public void setName(String name){
        this.Name = name;
    }

    public void setTypeAction(String typeAction){
        this.TypeAction = typeAction;
    }

    public void setProf(String prof){
        this.Prof = prof;
    }
}
