import ru.ifmo.se.pokemon.*;

public class Roselia extends Pokemon {
    public Roselia(String name, int level){
        super(name, level);
        setStats(50,60,45,100,80,65);
        setType(Type.GRASS);
        setMove(new ShadowBall(), new DazzlingGleam(), new StunSpore());
    }
}
