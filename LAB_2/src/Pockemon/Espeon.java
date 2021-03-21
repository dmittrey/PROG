package Pockemon;

import ru.ifmo.se.pokemon.*;
import PockemonMove.*;

public class Espeon extends Eevee {
    public Espeon(String name, int level){
        super(name, level);
        setStats(65,65, 60, 130,95,110);//
        setType(Type.PSYCHIC);
        setMove(new QuickAttack(), new TailWhip(), new Confide(), new DreamEater());
    }
}
