package commands;

import utility.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class for execute script and check it for recursion
 */
public class ExecuteScript extends CommandAbstract {

    private final Invoker invoker;

    /**
     * Class constructor
     *
     * @param aInvoker - Proxy class for call command's classes
     */
    public ExecuteScript(Invoker aInvoker) {
        super("execute_script", "Read and execute script from entered file" +
                TextFormatting.getBlueText("\n\tYou should to enter script name after entering a command"));
        invoker = aInvoker;
    }

    /**
     * We return status of execute
     *
     * (In future we can return list of commands from script)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) return TextFormatting.getRedText("\tYou should write script path!\n");
        else if (!(invoker.addScriptPath(aArg))) return TextFormatting.getRedText("\n\tRecursion has been found in " +
                "command: execute_script " + aArg + "!\n" +
                "\tPlease correct your script!\n");
        else {
            invoker.addScriptPath(aArg);
            try {
                Scanner scriptScanner = new Scanner(new File(aArg));
                Console console = new Console(scriptScanner);
                CommandReader commandReader = new CommandReader(console, invoker);
                commandReader.enable(true, true);
            } catch (FileNotFoundException exception) {
                return TextFormatting.getRedText("\tFile not found!\n");
            }
            invoker.removeScriptPath(aArg);
            return TextFormatting.getGreenText("\n\tThe script " + aArg + " was processed successfully!\n");
        }
    }
}
