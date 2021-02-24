package PockemonMove;
import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove{
    public Swagger() {
        super(Type.NORMAL, 0, 100);
    }
    @Override
    public void applyOppEffects(Pokemon p){
        p.setMod(Stat.ATTACK, 2);//"повышает атаку противника на две ступени"
    }
    @Override
    public String describe(){
        return "повысил атаку противника на 2 порядка" ;
    }
}