//реализация видов атак
import ru.ifmo.se.pokemon.*;


class Superpower extends PhysicalMove{
    protected Superpower() {
        super(Type.FIGHTING, 120, 100);
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, -1);
        p.setMod(Stat.DEFENSE, -1);
    }
    @Override
    protected String describe() {
        return "снизил свою атаку и защиту на 1 порядок";
    }
}

class IronDefense extends StatusMove{
    protected IronDefense() {
        super(Type.STEEL,0,100);
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.DEFENSE, 2);// "повышает Защиту пользователя на две ступени"
    }
    @Override
    protected String describe() {
        return "увеличил свою защиту на 2 ступени";
    }
}

class Swagger extends StatusMove{
    protected Swagger() {
        super(Type.NORMAL, 0, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.ATTACK, 2);//"повышает атаку противника на две ступени"
    }
    @Override
    protected String describe(){
        return "повысил атаку противника на 2 порядка" ;
    }
}

class RockPollish extends StatusMove{
    protected  RockPollish() {
        super(Type.GROUND, 0, 100);
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.SPEED, 2); // повышает скорость пользователя на две ступени.
    }
    @Override
    protected String describe(){
        return "увеличил свою скорость на два порядка";
    }
}

class ShadowBall extends SpecialMove{
    protected ShadowBall() {
        super(Type.GHOST, 80,100);
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, 4/5);
        p.getHP();
    }
    @Override
    protected String describe() {
        return "снизил атаку противника на 20%";
    }
}

class DazzlingGleam extends PhysicalMove{
    protected DazzlingGleam() {
        super(Type.FAIRY, 55,100);
    }
}

class QuickAttack extends PhysicalMove{
    protected QuickAttack() {
        super(Type.NORMAL, 40,100);
    }
    //Всегда срабатывает первой?
}

class TailWhip extends StatusMove{
    protected TailWhip() {
        super(Type.NORMAL, 0,100);
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, -1);
    }
    @Override
    protected String describe(){
        return "уменьшает защиту противника на 1 ступень";
    }
}

class Confide extends StatusMove{
    protected Confide(){
        super(Type.NORMAL, 0,100);
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, -1);
    }
    @Override
    protected String describe(){
        return "Уменьшает атаку противника на 1 ступень"
    }
}

class DreamEater extends SpecialMove{
    protected DreamEater() {
        super(Type.PSYCHIC,100,100);
    }
    //Работает если оппонент спит!
    //50% от нанесенного урона возвращается
}

class StunSpore extends SpecialMove{
    protected StunSpore() {
        super(Type.GRASS,0,75);
    }
    //парализует противника
}

class SweetScent extends StatusMove{
    protected SweetScent() {
        super(Type.NORMAL,0,100);
    }
    //снижает уклонение противника на одну единицу
}