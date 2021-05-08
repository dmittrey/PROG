package commands;

import java.util.HashMap;

/**
 * Класс для вывода справки по командам
 *
 * Реализация:
 *
 * Берем множество доступных команд и пробегаемся по всем объектам из этого множества выводя о них информацию
 */

public class Help extends CommandAbstract {
    private HashMap<String, CommandAbstract> commandsInfo;

    public Help(HashMap<String, CommandAbstract> aCommands){
        super("help", "display help for available commands");
        commandsInfo = aCommands;
    }

    public String execute(){
        StringBuilder sb = new StringBuilder();
        for (String i: commandsInfo.keySet()) {
            sb.append(commandsInfo.get(i).getDescription()).append("\n");
        }
        return sb.toString();
    }
}
