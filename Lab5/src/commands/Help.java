package commands;

import utility.TextFormatting;

import java.util.Map;

/**
 * Class for displaying all commands with explanations
 */
public class Help extends CommandAbstract {

    private final Map<String, CommandAbstract> commandsInfo;

    /**
     * Class constructor
     *
     * @param aCommands - Map of command's name and their classes
     */
    public Help(Map<String, CommandAbstract> aCommands) {
        super("help", "display help for available commands");
        commandsInfo = aCommands;
    }

    /**
     * We return list of commands
     *
     * (In future we can return map of commands and their descriptions)
     */
    @Override
    public Object execute(String aArg) {

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