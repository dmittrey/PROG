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
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (String command : previousCommands) {
                sb.append(++i).append(") ").append(command).append("\n");
            }
        return sb.toString();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}
