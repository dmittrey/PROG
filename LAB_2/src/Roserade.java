import ru.ifmo.se.pokemon.*;

public class Roserade extends Pokemon{
    public Roserade (String name, int level){
        super(name, level);
        setStats(60,70,65,125,105,90);
        setType(Type.GRASS);
        setMove(new Covet, new Absorb, new EnergyBall, new Superpower);
    }
}
