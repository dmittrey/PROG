package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class RockPollish extends StatusMove{
    public  RockPollish() {
        super(Type.GROUND, 0, 100);
    }
    @Override
    public void applySelfEffects(Pokemon p) {
        p.setMod(Stat.SPEED, 2); // повышает скорость пользователя на две ступени.
    }
    @Override
    public String describe(){
        return "увеличил свою скорость на два порядка";
    }
}
