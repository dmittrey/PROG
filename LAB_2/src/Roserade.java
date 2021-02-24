import ru.ifmo.se.pokemon.*;
import PockemonMove.*;

public class Roserade extends Roselia{
    public Roserade (String name, int level){
        super(name, level);
        setStats(60,70,65,125,105,90);
        setType(Type.GRASS);
        setMove( new ShadowBall(), new DazzlingGleam(), new StunSpore(), new SweetScent());
    }
}
