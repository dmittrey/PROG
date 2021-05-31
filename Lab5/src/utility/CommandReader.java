package utility;

import utility.Interfaces.CommandReaderInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CommandReader read and parse strings from input to commands and arguments
 */
public class CommandReader implements CommandReaderInterface {

    private final Console console;
    private final Invoker invoker;
    private final Pattern commandName;
    private final Pattern argName;
    private final boolean scriptExecutionStatus;


    public CommandReader(Invoker aInvoker, boolean aScriptExecutionStatus) {
        console = aInvoker.getConsole();

        invoker = aInvoker;

        scriptExecutionStatus = aScriptExecutionStatus;

        commandName = Pattern.compile("^\\w+\\s+");

        argName = Pattern.compile("^.+");
    }

    @Override
    public void enable() {

        String nextLine;
        String exitSave = "";
        String command;
        String arg;

        while (!exitSave.equals("exit ")) {

            if (scriptExecutionStatus && !console.hasNextLine()) break;

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

            if (!command.equals("exit ")) invoker.execute(command.trim(), arg.trim());
            else {
                console.print(TextFormatting.getGreenText("\tThank you for working in this program!\n"));
                System.exit(0);
            }
        }
    }
}