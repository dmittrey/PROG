public class Box {
    boolean OpenStatus;
    ContentOfBox Content;
    String Location;

    public Box(boolean status, ContentOfBox content, String location){
        OpenStatus = status;
        Content = content;
        Location = location;
    }

    public void Open(){
        this.OpenStatus = true;
    }

    public void Close(){
        this.OpenStatus = false;
    }

    //дописать из текста
}
