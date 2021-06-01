package commands;

import utility.CommandReader;
import utility.Interfaces.CommandReaderInterface;
import utility.Interfaces.InvokerInterface;
import utility.Invoker;
import utility.TextFormatting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class for execute script and check it for recursion
 */
public class ExecuteScript extends CommandAbstract {

    private final InvokerInterface invoker;

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
     * <p>
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
                Scanner previousScanner = invoker.getConsole().getScanner();
                Scanner scriptScanner = new Scanner(new File(aArg));
                invoker.getConsole().setScanner(scriptScanner);
                invoker.getConsole().enableExeStatus();

                CommandReaderInterface commandReader = new CommandReader(invoker, true);
                commandReader.enable();

                invoker.getConsole().disableExeStatus();
                invoker.getConsole().getScanner().close();
                invoker.getConsole().setScanner(previousScanner);
            } catch (FileNotFoundException exception) {
                return TextFormatting.getRedText("\tFile not found!\n");
            }

            invoker.removeScriptPath(aArg);
            return TextFormatting.getGreenText("\tThe script " + aArg + " was processed successfully!\n");
        }
    }
}
