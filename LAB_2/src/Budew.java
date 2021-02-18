import ru.ifmo.se.pokemon.*;

public class Budew extends Pokemon{
    public Budew(String name, int level){
        super(name,level);
        setStats(40,30,35,50,70,55);
        setType(Type.GRASS);
        setMove(new Covet, new GigaDrain, new SeedBomb, new Snore);
    }
}
