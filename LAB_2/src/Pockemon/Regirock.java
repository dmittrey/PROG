package Pockemon;

import ru.ifmo.se.pokemon.*;
import PockemonMove.*;

public class Regirock extends Pokemon {
    public Regirock (String name, int level){
        super(name, level);
        setStats(80, 100, 200, 50, 100, 50);
        setType(Type.GROUND);
        setMove(new SuperPower(), new IronDefense(), new Swagger(), new RockPollish());
    }
}
