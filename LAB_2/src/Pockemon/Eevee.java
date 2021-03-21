package Pockemon;

import ru.ifmo.se.pokemon.*;
import PockemonMove.*;

public class Eevee extends Pokemon{
    public Eevee(String name, int level){
        super(name,level);
        setStats(55,55,50,45,65,55);
        setType(Type.NORMAL);
        setMove(new QuickAttack(), new TailWhip(), new Confide());
    }
}
