package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class ShadowBall extends SpecialMove{
    public ShadowBall() {
        super(Type.GHOST, 80,100);
    }
    @Override
    public void applyOppEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, 4/5);
        p.getHP();
    }
    @Override
    public String describe() {
        return "снизил атаку противника на 20%";
    }
}
