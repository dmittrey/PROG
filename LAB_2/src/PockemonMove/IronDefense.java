package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class IronDefense extends StatusMove{
    public IronDefense() {
        super(Type.STEEL,0,100);
    }
    @Override
    public void applySelfEffects(Pokemon p){
        p.setMod(Stat.DEFENSE, 2);// "повышает Защиту пользователя на две ступени"
    }
    @Override
    public String describe() {
        return "увеличил свою защиту на 2 ступени";
    }
}
