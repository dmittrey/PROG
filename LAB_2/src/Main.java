import ru.ifmo.se.pokemon.*;

public class Main {

    public static void main(String[] args) {
        Battle dom = new Battle();
        dom.addAlly(new Regirock("Игорь", 1));
        dom.addAlly(new Eevee("Аркадий", 1));
        dom.addAlly(new Espeon("Паша", 1));
        dom.addFoe(new Budew("Дима", 1));
        dom.addFoe(new Roselia("Валера", 1));
        dom.addFoe(new Roserade("Вазген", 1));
        dom.go();
    }
}
