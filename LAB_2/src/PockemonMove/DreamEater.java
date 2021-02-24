package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class DreamEater extends SpecialMove{
    public DreamEater() {
        super(Type.PSYCHIC,100,100);
    }
    @Override
    public void applySelfEffects(Pokemon p){
        p.setMod(Stat.HP, 5);
    }
}
