package commands;

import utility.TextFormatting;

import java.util.Queue;

/**
 * Class for displaying last 14 commands
 */
public class History extends CommandAbstract {

    Queue<String> previousCommands;

    /**
     * Class constructor
     *
     * @param aPreviousCommands - Queue of last 14 commands
     */
    public History(Queue<String> aPreviousCommands) {
        super("history", "print the last 14 commands (without their arguments)");
        previousCommands = aPreviousCommands;
    }

    /**
     * We return execute status
     *
     * (in future we can return queue of last 14 commands and print on client)
     */
    @Override
    public Object execute(String aArg) {
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
