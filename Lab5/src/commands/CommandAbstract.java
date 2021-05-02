package commands;

/**
 *
 * Абстрактный класс команды который хранит описание и имя команды
 */

public class CommandAbstract implements CommandInterface{

    private final String description;

    public CommandAbstract(String name, String aDescription){
        description = aDescription;
    }

    /**
     * @return Описание программы
     */
    @Override
    public String getDescription() {
        return description;
    }


    /**
     *
     * Вот этот момент я скорее всего уберу потому что смысл переопределять метод,
     * который ничего не делает на данном этапе
     *
     * Скорее всего в Invoker экстендится этот класс и поэтому просит переопределить
     * @param arg
     */
    @Override
    public void execute(String arg) {

    }
}
