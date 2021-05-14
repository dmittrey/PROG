package commands;

import utility.Console;
import utility.TextFormatting;

import java.util.Queue;

public class History extends CommandAbstract {

    Queue<String> previousCommands;
    Console console;

    public History(Queue<String> aPreviousCommands, Console console) {
        super("clear", "print the last 14 commands (without their arguments)");
        previousCommands = aPreviousCommands;
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {
            StringBuilder sb = new StringBuilder();
            for (String command : previousCommands) {
                sb.append(command).append("\n");
                //продумать момент как ограничить кол-во листа до 14
                //и рефакторинг подхода к приёму аргументов а то заебало этот случай обрабатывать
            }
        return sb.toString();
        } else {
            return TextFormatting.getRedText("Arguments entered incorrectly\n");
        }
    }
}
