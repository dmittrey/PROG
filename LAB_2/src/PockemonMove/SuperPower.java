package PockemonMove;
import ru.ifmo.se.pokemon.*;


public class SuperPower extends PhysicalMove{
    public SuperPower() {
        super(Type.FIGHTING, 120, 100);
    }
    @Override
    public void applySelfEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, -1);
        p.setMod(Stat.DEFENSE, -1);
    }
    @Override
    public String describe() {
        return "снизил свою атаку и защиту на 1 порядок";
    }
}
