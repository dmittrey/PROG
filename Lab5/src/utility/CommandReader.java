package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <code>commandReader</code> read and parse strings from input to commands and arguments
 */
public class CommandReader {

    private final Console console;
    private final Invoker invoker;
    private final Pattern commandName;
    private final Pattern argName;


    public CommandReader(Console aConsole, Invoker aInvoker) {
        console = aConsole;

        invoker = aInvoker;

        commandName = Pattern.compile("^\\w+\\s+");

        argName = Pattern.compile("^.+");
    }

    /**
     * <code>enable</code> - method to enable line entry
     * @param printPermission - variable to access print commands after enjoy line.
     *
     * if command includes letter only we explain invoker and give him command and argument
     */
    public void enable(boolean printPermission) {

        String nextLine;
        String exitSave = "";
        String command;
        String arg;

        while (!exitSave.equals("exit ")) {

            console.print("Enter the command: ");
            nextLine = console.read() + " ";
            exitSave = nextLine;

            Matcher matcher = commandName.matcher(nextLine);

            if (matcher.find()) {
                command = matcher.group();
            } else {
                console.print(TextFormatting.getRedText("\tCommand is incorrect. Please, try again!\n"));
                continue;
            }

            nextLine = nextLine.substring(command.length());
            matcher = argName.matcher(nextLine);

            arg = matcher.find() ? matcher.group() : "";

            if (printPermission) console.print(TextFormatting.getGreenText(command));

            if (!command.equals("exit ")) invoker.execute(command.trim(), arg);
            else System.exit(0);
        }
    }
}