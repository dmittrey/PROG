package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class SweetScent extends StatusMove{
    public SweetScent() {
        super(Type.NORMAL,0,100);
    }
    @Override
    public void applyOppEffects(Pokemon p){
        p.setMod(Stat.EVASION, -5);
    }
}
