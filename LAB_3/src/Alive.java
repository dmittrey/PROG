public interface Alive {
    void Move(String location);

    void GetScared();

    void Open(NotAlive x);

    void Close(NotAlive x);
}
