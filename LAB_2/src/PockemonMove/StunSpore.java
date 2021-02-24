package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class StunSpore extends SpecialMove{
    public StunSpore() {
        super(Type.GRASS,0,75);
    }
    @Override
    public void applyOppEffects(Pokemon p){
        Effect.paralyze(p);
    }
}