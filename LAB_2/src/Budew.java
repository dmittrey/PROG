import ru.ifmo.se.pokemon.*;

public class Budew extends Pokemon{
    public Budew(String name, int level){
        super(name,level);
        setStats(40,30,35,50,70,55);//характеристики
        setType(Type.GRASS);//тип
        setMove(new ShadowBall(), new DazzlingGleam());//ставим атаки
    }
}
