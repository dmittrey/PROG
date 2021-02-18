import ru.ifmo.se.pokemon.*;

public class Espeon extends Pokemon{
    public Espeon(String name, int level){
        super(name, level);
        setStats(65,65, 60, 130,95,110);
        setType(Type.PSYCHIC);
        setMove(new Covet, new HyperVoice, new IrnoTail, new ZenHeadbutt);
    }
}
