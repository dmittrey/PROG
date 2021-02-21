public interface Alive {
    void Move(String location);
    void GetScared();

    //добавить в конструктор поле выше
    void Open(NotAlive x);

    void Close(NotAlive x);
}
