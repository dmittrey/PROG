package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class TailWhip extends StatusMove{
    public TailWhip() {
        super(Type.NORMAL, 0,100);
    }
    @Override
    public void applyOppEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, -1);
    }
    @Override
    public String describe(){
        return "уменьшает защиту противника на 1 ступень";
    }
}
