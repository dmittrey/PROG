package Pockemon;

import ru.ifmo.se.pokemon.*;
import PockemonMove.*;

public class Roselia extends Budew {
    public Roselia(String name, int level){
        super(name, level);
        setStats(50,60,45,100,80,65);
        setType(Type.GRASS);
        setMove(new ShadowBall(), new DazzlingGleam(), new StunSpore());
    }
}
