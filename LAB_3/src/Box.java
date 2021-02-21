public class Box implements NotAlive {
    private boolean OpenStatus;
    private ContentOfBox Content;
    private int Location;

    public Box(boolean status, ContentOfBox content, int location) {
        OpenStatus = status;
        Content = content;
        Location = location;
    }

    public void Open() {
        this.OpenStatus = true;
    }

    public void Close() {
        this.OpenStatus = false;
    }

    public ContentOfBox GetContent() {
        return this.Content;
    }

    public boolean getOpenStatus() {
        return this.OpenStatus;
    }

    public String getLocation() {
        return "Ящик №" + this.Location;
    }
}
