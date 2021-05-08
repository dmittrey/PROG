package commands;

/**
 *
 * Абстрактный класс команды который хранит описание и имя команды
 */

public abstract class CommandAbstract implements CommandInterface{

    private final String name;
    private final String description;

    public CommandAbstract(String aName, String aDescription){
        name = aName;
        description = aDescription;
    }

    /**
     * @return Описание программы
     */
    @Override
    public String getDescription() {

        switch (name) {
            case "help":
            case "info":
            case "show":
            case "clear":
            case "save":
            case "exit":
            case "history":
            case "min_by_students_count":
                return name + " : " + description;
            case "add":
            case "update id":
            case "add_if_max":
            case "add_if_min":
                return name + " {element} : " + description;
            case "remove_by_id":
                return name + " id : " + description;
            case "execute_script":
                return " file_name : " + description;
            case "count_less_than_students_count":
                return name + " studentsCount : " + description;
            default:
                return name + " name : " + description;
        }
    }
    @Override
    public abstract String execute();
}
