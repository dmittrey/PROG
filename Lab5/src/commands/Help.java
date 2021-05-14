package commands;

import utility.Invoker;
import utility.TextFormatting;

import java.util.HashMap;

/**
 * @author dmittrey
 * <p>
 * Class for displaying all commands with explanations
 */

public class Help extends CommandAbstract {

    /**
     * Map of all commands
     */
    private final HashMap<String, CommandAbstract> commandsInfo;

    public Help(HashMap<String, CommandAbstract> aCommands) {
        super("help", "display help for available commands");
        commandsInfo = aCommands;
    }

    /**
     * Function to print all commands
     *
     * @param aArg - command arguments
     * @return List of commands or error message
     * @see Invoker#execute(String, String)
     */
    public String execute(String aArg) {

        if (aArg.equals("")) {
            StringBuilder sb = new StringBuilder();
            sb.append(TextFormatting.getBlueText("\nList of commands:\n\n"));
            for (String i : commandsInfo.keySet()) {
                sb.append("\t").append(commandsInfo.get(i).getDescription()).append("\n\n");
            }
            sb.append("\t").append("exit : end the program (without saving it to a file)").append("\n\n");
            return sb.toString();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}