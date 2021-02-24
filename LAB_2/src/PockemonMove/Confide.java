package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove{
    public Confide(){
        super(Type.NORMAL, 0,100);
    }
    @Override
    public void applyOppEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, -1);
    }
    @Override
    public String describe(){
        return "Уменьшает атаку противника на 1 ступень";
    }
}